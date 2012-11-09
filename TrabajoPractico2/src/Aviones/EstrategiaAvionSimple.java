package Aviones;

import Pistas.Pista;
import Utilitarios.Trayectoria;
import Utilitarios.Vector;

public class EstrategiaAvionSimple implements EstrategiaAvion
{
	public Vector Avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
	{
		double distanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(posicion).norma();
		
		Vector proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
		
		double proximaDistanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(proximaPosicion).norma();
		
		//Si me voy a acercar al waypoint sigo avanzando
		if(distanciaAlWaypoint >= proximaDistanciaAlWaypoint)
			return proximaPosicion;
		
		//Sino cambio de direccion, y si no hay sigo derecho
		
		trayectoriaDeVuelo.QuitarWaypoint();
		
			//El avion simple mantiene la trayectoria de vuelo
		if(trayectoriaDeVuelo.Waypoint() == null)
			trayectoriaDeVuelo.AgregarWaypoint(proximaPosicion.multiplicarPorEscalar(velocidad));	
		else
			//recalculo la proxima posicion
			proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
	
		return proximaPosicion;	
	}
	
	public boolean puedeAterrizarEn(Pista unaPista){
		return unaPista.puedeAterrizarAvionSimple();
	}
	
}
