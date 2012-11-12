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
	          if (avionAVerificar.verificarSiColicionaConOtro(this.aviones))
	        	  return true;
		} 
		
		return false;
	}
	
	public void aterrizarAviones(){
		Iterator<Pista> iteradorPista = pistas.listIterator();
		while( iteradorPista.hasNext()) {
	          Pista pistaDondeAterrizar = (Pista) iteradorPista.next();
	          pistaDondeAterrizar.aterrizarAviones(this.aviones);
		} 		
	}
	
	public void moverAviones(){
		Iterator<Avion> iterador = aviones.listIterator();
		while( iterador.hasNext() ) {
	          Avion avionAMover = (Avion) iterador.next();
	          avionAMover.avanzar();
		} 
	}
	
	
}
