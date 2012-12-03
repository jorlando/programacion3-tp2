package modelo.Aviones;

import java.util.ArrayList;
import java.util.Iterator;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;


public class Avion implements ObjetoPosicionable, ObjetoVivo
{
	private Vector posicion;
	private Trayectoria trayectoriaDeVuelo; 
	private EstrategiaAvion tipoDeAvion;
	private double velocidad;
	private int tamaño;
		
	public Avion(Vector PosicionInicial, Trayectoria trayectoriaInicial, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = trayectoriaInicial;
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
		this.setTamaño(tipoDeAvion.tamaño());
	}
	
	public Avion(Vector posicionInicial, Vector direccionInicial, EstrategiaAvion tipoDeAvion)
	{
		this(posicionInicial, new Trayectoria(direccionInicial), tipoDeAvion);
	}
	
	public Vector obtenerDireccion()
	{	
		return this.trayectoriaDeVuelo.Direccion(this.posicion); 
	}

	public Vector obtenerPosicion()
	{
		return this.posicion;
	}
	
	protected void modificarPosicion(Vector posicion)
	{
		this.posicion = posicion;
	}
	
	public void avanzar()
	{
		this.posicion = tipoDeAvion.avanzar(this.posicion, this.velocidad, this.trayectoriaDeVuelo);
	}
	
	public EstrategiaAvion obtenerEstrategia(){
		return this.tipoDeAvion;
	}
	
	public boolean puedoAterrizarEn(Pista unaPista){
		return (unaPista.calcularAterrizaje(this) && tipoDeAvion.puedeAterrizarEn(unaPista));
	}
	
	public boolean colisionaCon(Avion otroAvion){
		return ((((this.posicion.restarOtroVector(otroAvion.posicion)).norma())-(this.getTamaño()+otroAvion.getTamaño())<0) && 
				tipoDeAvion.calcularChoqueCon(otroAvion));
	}
	
	public boolean verificarSiColicionaConOtro(ArrayList<Avion> otrosAviones)
	{
		Iterator<Avion> iteradorAviones = otrosAviones.listIterator();
		while( iteradorAviones.hasNext() ) {
	          Avion avionAVerificar = (Avion) iteradorAviones.next();
	          // dentro de la lista de aviones recibida por parametro tambien esta el avion que verifica
	          if (avionAVerificar != this){
	        	  if( this.colisionaCon(avionAVerificar) ) return true;
	          }
		} 
	return false;
	}
	
	public int getX(){
		return (int)this.posicion.getX();
	}
	
	public int getY(){
		return (int)this.posicion.getY();
	}
	
	public void vivir(){ //esto sirve depende como lo hagamos
		avanzar();
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
	
}
