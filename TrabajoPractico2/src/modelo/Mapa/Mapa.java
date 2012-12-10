package modelo.Mapa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;

import vista.Aviones.VistaAvion;
import vista.Objetos.VistaMapa;
import vista.Pistas.*;
import vista.Ventanas.VistaMensajeError;
import vista.Ventanas.vistapunto;

import Excepciones.ImposibleCalcularPosicion;

import modelo.Aviones.*;
import modelo.Utilitarios.*;
import modelo.Pistas.*;

import fiuba.algo3.titiritero.modelo.*;


public class Mapa implements ObjetoVivo, ObjetoPosicionable{
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private int ancho;
	private int largo;
	private Nivel nivel;
	private GameLoop gameLoop;
	private ObservadorDeGameLoop observador;
	
	public Mapa(int ancho, int largo, GameLoop gameLoop){
		this.ancho = ancho;
		this.largo = largo;
		aviones = new ArrayList<Avion>();
		pistas = new ArrayList<Pista>();
		nivel = new Nivel();
		this.gameLoop = gameLoop;
		this.observador = new ObservadorDeMapa(this);
		this.gameLoop.agregarObservador(observador);
		this.gameLoop.agregar(nivel);
	}
	
	public Mapa(GameLoop gameLoop){
		this(800,600, gameLoop);
	}
	
	public void agregarPista(Pista unaPista){
		pistas.add(unaPista);
	}
	
	
	public Hashtable obtenerDireccionParaComputarizado()
	{
		boolean continuoBuscando=true;
		Hashtable hashResultado=new Hashtable();
		while (continuoBuscando)
		{
			Random generator = new Random();
			int valorRandom = generator.nextInt(this.pistas.size());
			Pista unaPista = this.pistas.get(valorRandom);
			if (unaPista.tieneDireccion())
			{
				continuoBuscando=false;
				Hashtable unHash= unaPista.obtenerPosicionDireccion();
				hashResultado.put("posicion", this.obtenerPosicionDesdeBorde(unHash));
				hashResultado.put("direccion", unHash.get("posicion"));
			}
		}
		return hashResultado;
	}
	
	public Vector obtenerPosicionDesdeBorde(Hashtable unHash)
	{
		Vector posicion = (Vector) unHash.get("posicion");
		Vector direccion = (Vector) unHash.get("direccion");
				
		while (!(this.esElBorde(posicion)))
		{
			posicion=posicion.restarOtroVector(direccion);
		}
		posicion= this.aplicarVarianza(posicion, (double)unHash.get("ancho"));
		return posicion;
	}
	public Vector aplicarVarianza(Vector posicion, double variable)
	{
		Random generator = new Random();
		int valor = generator.nextInt((int)variable*2);
		
		ArrayList valoresPosibles = new ArrayList();
		valoresPosibles.add(valor);
		valoresPosibles.add((0-valor));
		int indice = generator.nextInt(valoresPosibles.size());
		int valorParaModificar = (int) valoresPosibles.get(indice);
		double y;
		double x;
		
		if (posicion.getX()<=0 || posicion.getX()>=this.largo)
		{
			y=(posicion.getY()-valorParaModificar);
			x=posicion.getX();
		}
		else
		{
			y=posicion.getY();
			x=(posicion.getX()-valorParaModificar);
		}
		return (new Vector(x,y));
	}
	
	public boolean esElBorde(Vector unaPos)
	{
		return ((unaPos.getX()<=0 || unaPos.getX()>=this.largo)||(unaPos.getY()<=0 || unaPos.getY()>=this.ancho));
	}
	
	public void agregarAvion(Avion unAvion){
		aviones.add(unAvion);
	}
	
	//Creado solo para TEST
	public ArrayList<Pista> obtenerPistas(){
		return this.pistas;
	}
	//Creado solo para TEST
		public ArrayList<Avion> obtenerAviones(){
			return this.aviones;
		}
	
	public boolean verificarColisiones(){
		Iterator<Avion> iterador = aviones.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionAVerificar = (Avion) iterador.next();
	          if (avionAVerificar.verificarSiColicionaConOtro(this.aviones))//esto es repetitivo hay que ver si se puede mejorar
	        	  return true;
		} 
		
		return false;
	}
	
	public void aterrizarAviones(){
		//hay que hacer que aumente un punto por cada avion aterrizado
		Iterator<Pista> iteradorPista = pistas.listIterator();
		while(iteradorPista.hasNext()) {
			Pista pistaDondeAterrizar = (Pista) iteradorPista.next();
			ArrayList<Avion> avionesAterrizados = pistaDondeAterrizar.aterrizarAviones(this.aviones);
			if (avionesAterrizados.size()>0) this.borrarAviones(avionesAterrizados);
		} 		
	}
	public void borrarAvionesQueSeFueronDelMapa()
	{
		Iterator<Avion> iterador = aviones.listIterator();
		ArrayList<Avion> avionesABorrar = new ArrayList<Avion>();
		while(iterador.hasNext()) {
			Avion avionAEvaluar = (Avion)iterador.next();
	          Vector posicionDelAvion = avionAEvaluar.obtenerPosicion();
	          if ((posicionDelAvion.getX()<0 || posicionDelAvion.getX()>this.largo)||(posicionDelAvion.getY()<0 || posicionDelAvion.getY()>this.ancho))
	          {
	        	  avionesABorrar.add(avionAEvaluar);
	          }
		} 
		if (avionesABorrar.size()>0) this.borrarAviones(avionesABorrar);
		
	}
	
	private void borrarAviones(ArrayList<Avion> avionesAterrizados)
	{
		Iterator<Avion> iterador = avionesAterrizados.listIterator();
		while( iterador.hasNext() ) {
			  Avion avionABorrar = (Avion) iterador.next();
	          this.gameLoop.remover(avionABorrar.obtenerVista());
	          this.gameLoop.remover(avionABorrar);
	          this.aviones.remove(avionABorrar);
	          nivel.AvionAterrizado();
		}	
	}
	
	public void moverAviones(){
		Iterator<Avion> iterador = aviones.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionAMover = (Avion) iterador.next();
	          avionAMover.avanzar();
		} 
	}

	public Vector obtenerPosicionLibre() throws ImposibleCalcularPosicion {
		
		Vector posicion = this.calcularPosicionBorde();

		if (!this.posicionEstaLibre(posicion)){
			throw new ImposibleCalcularPosicion();
		}

		return posicion;
	}
	
	private Vector calcularPosicionBorde() {
		
		int x = 0,y = 0;
		int pos1,pos2;
		Random generator = new Random();
		pos1 = generator.nextInt(2);
		pos2 = generator.nextInt(2);
		
		if (pos1 == 0){
			x = generator.nextInt(this.ancho+1);
			// lo comentado abajo depende de donde se tome el (0,0)
			if (pos2 == 0) y = 0; // (x,0) aparece del borde de abajo
			else y = this.largo; // (x,largo) aparece del borde de arriba
		}
		else if (pos1 == 1){
			y = generator.nextInt(this.largo+1);
			if (pos2 == 0) x = 0; // (0,y) aparece del lado izquierdo
			else x = this.ancho; // (ancho,y) aparece del lado derecho
		}
		
		return new Vector(x,y);
		
	}
	
	private boolean posicionEstaLibre(Vector posicion) {
		
		double distanciaMin = 20;
		Vector posicionAvion;
		Iterator<Avion> iterador = aviones.listIterator();
		
		while( iterador.hasNext()) {
	          Avion avion = (Avion) iterador.next();
	          posicionAvion = avion.obtenerPosicion();
	          if (posicion.restarOtroVector(posicionAvion).norma() < distanciaMin) return false;
		}
		
		return true;
	}

	
	public int getLargo(){
		return this.largo;
	}
	
	public int getAncho(){
		return this.ancho;
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

	@Override
	public void vivir() 
	{
		
		if (this.verificarColisiones())
		{
			System.out.println("¡¡¡¡¡CHOQUE!!!!!");
			MensajeGameOver mensajeFinal = new MensajeGameOver();
			VistaMensajeError vistaMensaje = null;
			try {
				vistaMensaje = new VistaMensajeError(mensajeFinal);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			gameLoop.agregar(vistaMensaje);
			gameLoop.detenerEjecucion();
		}
	}
	
	public void iniciarSimulacion(){
		
		
		//VistaMapa vistaMapa = new VistaMapa(this);
		/* Creamos las pistas */
		Pista pistaSimple = new PistaSimpleEntrada(new Vector(300,300), new Vector(1,0), 40, 80);
		Pista pistaPesada = new PistaPesadaSimple(new Vector(60,150), new Vector(0,1), 40, 80);
		Pista pistaHelipuerto = new Helipuerto(new Vector(450,450),80);
		Pista pistaDoble = new PistaDobleEntrada(new Vector(250,40), new Vector(500,40), 80, 80);
		
		VistaPistaSimple vistaPistaSimple=null;
		VistaPistaPesadaSimple vistaPistaPesada=null;
		VistaHelipuerto vistaHelipuerto=null;
		VistaPistaDobleEntrada vistaDoble= null;
		
		//VistaMapa unaVistaMapa=null;
		try {
			vistaPistaSimple = new VistaPistaSimple(pistaSimple);
			vistaPistaPesada = new VistaPistaPesadaSimple(pistaPesada);
			vistaHelipuerto = new VistaHelipuerto(pistaHelipuerto);
			vistaDoble = new VistaPistaDobleEntrada(pistaDoble);
			//unaVistaMapa = new VistaMapa(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.agregarPista(pistaSimple);
		this.agregarPista(pistaPesada);
		this.agregarPista(pistaHelipuerto);
		this.agregarPista(pistaDoble);
		/* **************************************** */
		//gameLoop.agregar(unaVistaMapa); //esta vista hay que ponerla al fondo.
		gameLoop.agregar(this);
		gameLoop.agregar(vistaPistaSimple);
		gameLoop.agregar(vistaPistaPesada);
		gameLoop.agregar(vistaHelipuerto);
		gameLoop.agregar(vistaDoble);
		/* **************************************** */
		gameLoop.iniciarEjecucion();
	}
	
	public void agregarAviones() throws IOException{
		if (nivel.debeGenerarAvion())
		{
			// le preguntamos al nivel que avion agregar 
			Random generator = new Random();
			int x = generator.nextInt(this.largo);
			int y = generator.nextInt(this.ancho);
			int lado = (x % 4) + 1; //elijo de que lado va a salir el avion 1 arriba, 2 derecha, 3 abajo y 4 izquierda
			
			switch(lado)
			{
				case 1:
					y= 0;
					break;
				case 2:
					x= this.largo;
					break;
				case 3:
					y= this.ancho;
					break;
				case 4:
					x= 0;
					break;
			}
			
			Random generador = new Random();
			Avion nuevoAvion;
			switch(generador.nextInt(4))
			{
			case 0:
				nuevoAvion = new Avion(new Vector(x,y), new Vector(320,240), new EstrategiaAvionSimple());
				break;
			case 1:
				nuevoAvion = new Avion(new Vector(x,y), new Vector(320,240), new EstrategiaAvionHelicoptero());
				break;
			case 2:
				nuevoAvion = new Avion(new Vector(x,y), new Vector(320,240),new EstrategiaAvionPesado());
				break;
			case 3:
				Hashtable datosComputarizado=this.obtenerDireccionParaComputarizado();
				Vector posicionAvion = (Vector) datosComputarizado.get("posicion");
				nuevoAvion = new Avion(posicionAvion, (Vector) datosComputarizado.get("direccion"), new EstrategiaAvionComputarizado());
				break;
			default:
				nuevoAvion = new Avion(new Vector(x,y), new Vector(320,240), new EstrategiaAvionSimple());
				}
		this.agregarAvion(nuevoAvion);
		gameLoop.agregar(nuevoAvion);
		VistaAvion vistaAvion = new VistaAvion(nuevoAvion);
		gameLoop.agregar(vistaAvion);
		}
	}

	public void detenerSimulacion() {
		gameLoop.detenerEjecucion();
	}
	
	public Avion obtenerAvionEn(Vector posicionABuscar){
		
		Vector posicionAvion;
		Iterator<Avion> iterador = aviones.listIterator();
		
		while( iterador.hasNext()) {
	          Avion avion = (Avion) iterador.next();
	          posicionAvion = avion.obtenerPosicion();
	          if (posicionAvion.restarOtroVector(posicionABuscar).norma() < avion.getTamaño()*1.2){
	        	  return avion;
	          }
		}
		
		return null;
		
	}
	
}
