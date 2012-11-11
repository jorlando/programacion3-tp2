package Mapa;

import java.util.ArrayList;
import Aviones.Avion;
import Pistas.Pista;
import java.util.Iterator;

public class Mapa {
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private double ancho;
	private double largo;
	
	public Mapa(double ancho, double largo){
		this.ancho = ancho;
		this.largo = largo;
		aviones = new ArrayList<Avion>();
		pistas = new ArrayList<Pista>();
	}
	
	public void agregarPista(Pista unaPista){
		pistas.add(unaPista);
	}
	
	public void agregarAvion(Avion unAvion){
		aviones.add(unAvion);
	}
	
	public boolean verificarColisiones(){
		//verifica si hay aviones que chocaron.
		//seria la condicion para finalizar el juego.
		return false;
	}
	
	public void aterrizarAviones(){
		//aterriza los aviones que puedan aterrizar sobre alguna pista.
	}
	
	public void moverAviones(){
		Iterator<Avion> iterador = aviones.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionAMover = (Avion) iterador.next();
	          avionAMover.avanzar();
		} 
	}

}
