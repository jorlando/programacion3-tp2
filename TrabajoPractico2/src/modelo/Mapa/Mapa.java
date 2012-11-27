package modelo.Mapa;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.Aviones.Avion;
import modelo.Pistas.Pista;
import modelo.Jugador;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;





public class Mapa implements ObjetoVivo, Posicionable{
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private double ancho;
	private double largo;
	private Jugador jugador;
	
	public Mapa(double ancho, double largo){
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
	
	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
	
	public int getX(){
		return 0;
	}
	
	public int getY(){
		return 0;
	}
	
	public void vivir(){
		//habria que hacer el gameloop aca
	}
	
}
