package modelo.Mapa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Excepciones.ImposibleCalcularPosicion;

import modelo.Aviones.Avion;
import modelo.Pistas.Pista;
import modelo.Utilitarios.Vector;





public class Mapa{
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private int ancho;
	private int largo;
	
	public Mapa(int ancho, int largo){
		this.ancho = ancho;
		this.largo = largo;
		aviones = new ArrayList<Avion>();
		pistas = new ArrayList<Pista>();
	}
	
	public Mapa(){
		new Mapa(800,600);
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
	
	public void borrarAterrizados(ArrayList<Avion> avionesAterrizados)
	{
		Iterator<Avion> iterador = avionesAterrizados.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionABorrar = (Avion) iterador.next();
	          this.aviones.remove(avionABorrar);
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
	
}
