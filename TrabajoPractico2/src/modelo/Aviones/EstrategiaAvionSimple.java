package modelo.Aviones;

import modelo.Pistas.Pista;
import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;

public class EstrategiaAvionSimple implements EstrategiaAvion
{
	private static int tamaño = 20;
	private static String rutaImagen="recursos/imagenes/avionSimple2.png";
	
	public Vector avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
	{
		double distanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(posicion).norma();
		
		Vector proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
		
		double proximaDistanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(proximaPosicion).norma();
		
		//Si me voy a acercar al waypoint sigo avanzando
		if(distanciaAlWaypoint >= proximaDistanciaAlWaypoint)
		{
		//	System.out.println(proximaPosicion.getX() + "--" + proximaPosicion.getY());
			return proximaPosicion;
		}
		//Sino cambio de direccion, y si no hay sigo derecho
		
		trayectoriaDeVuelo.QuitarWaypoint();
		
			//El avion simple mantiene la trayectoria de vuelo
		if(trayectoriaDeVuelo.Waypoint() == null)
			trayectoriaDeVuelo.AgregarWaypoint(proximaPosicion.multiplicarPorEscalar(velocidad));	
		else
			//recalculo la proxima posicion
			proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
	//	System.out.println(proximaPosicion.getX() + "--" + proximaPosicion.getY());
		return proximaPosicion;	
	}
	
	public String miImagen()
	{
		return this.rutaImagen;
	}	
	public boolean puedeAterrizarEn(Pista unaPista){
		return unaPista.puedeAterrizarAvionSimple();
	}
	
	public boolean calcularChoqueCon(Avion unAvion){
		return true;
	}

	
	public int tamaño() 
	{
		return this.tamaño;
	}

	
}
