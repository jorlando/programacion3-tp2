package modelo.Mapa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import vista.Aviones.VistaAvionSimple;

import Excepciones.ImposibleCalcularPosicion;

import modelo.Aviones.Avion;
import modelo.Aviones.EstrategiaAvionSimple;
import modelo.Pistas.Pista;
import modelo.Utilitarios.Vector;

import fiuba.algo3.titiritero.modelo.*;


public class Mapa implements ObjetoVivo, ObjetoPosicionable{
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private int ancho;
	private int largo;
	private Nivel nivel;
	private GameLoop gameLoop;
	
	public Mapa(int ancho, int largo, GameLoop gameLoop){
		this.ancho = ancho;
		this.largo = largo;
		aviones = new ArrayList<Avion>();
		pistas = new ArrayList<Pista>();
		nivel = new Nivel();
		this.gameLoop = gameLoop;
	}
	
	public Mapa(GameLoop gameLoop){
		this(800,600, gameLoop);
	}
	
	public void agregarPista(Pista unaPista){
		pistas.add(unaPista);
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
			if (avionesAterrizados.size()>0) this.borrarAterrizados(avionesAterrizados);
		} 		
	}
	
	private void borrarAterrizados(ArrayList<Avion> avionesAterrizados)
	{
		Iterator<Avion> iterador = avionesAterrizados.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionABorrar = (Avion) iterador.next();
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

	/* Falta Implementar */
	public Vector calcularDireccionParaPosicion(Vector unaPosicion) {
		return new Vector(0,0);
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
		this.moverAviones();
		this.aterrizarAviones();
		
		if (this.verificarColisiones())
		{
			System.out.println("¡¡¡¡¡CHOQUE!!!!!");
		}
		
		this.agregarAviones();
	}

	static int pepe = 0;
			
	private void agregarAviones() 
	{
			if(pepe % 10000000 == 0 )
			{	
				Avion nuevoAvion = new Avion(new Vector(0,300), new Vector(320, 240), new EstrategiaAvionSimple());
				this.agregarAvion(nuevoAvion);
				VistaAvionSimple vistaAvion = new VistaAvionSimple(nuevoAvion);
				gameLoop.agregar(vistaAvion);
			}
			pepe++;
		
	}
	
}
