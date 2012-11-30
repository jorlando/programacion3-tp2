package modelo.Mapa;

import java.util.ArrayList;
import java.util.Iterator;

import Excepciones.ImposibleCalcularPosicion;

import modelo.Aviones.Avion;
import modelo.Pistas.Pista;
import modelo.Utilitarios.Vector;





public class Mapa{
	
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

	
	/* Falta Implementar */ 
	public Vector obtenerPosicionLibre() throws ImposibleCalcularPosicion {
		//random posicion
		//verificamos que esta libre
			//sino volvemos a probar (Aca puede pasar que se haga muy prolongado, habria que ver si cortamos el ciclo y ahi lanzamos la exepcion)
		return (new Vector(0,0));
	}
	
	/* Falta Implementar */
	public Vector calcularDireccionParaPosicion(Vector unaPosicion) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
