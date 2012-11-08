package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;

public class EstrategiaAvionHelicoptero implements EstrategiaAvion
{

	public Vector Avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
	{
		if(trayectoriaDeVuelo.Waypoint() != null)
		{
			double distanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(posicion).norma();
			
			Vector proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
			
			double proximaDistanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(proximaPosicion).norma();
			
			//Si me voy a acercar al waypoint sigo avanzando
			if(distanciaAlWaypoint >= proximaDistanciaAlWaypoint)
				return proximaPosicion;
			
			//Sino cambio de direccion
			
			trayectoriaDeVuelo.QuitarWaypoint();
			
				//Si no hay mas direcciones el avion helicoptero se frena
			if(trayectoriaDeVuelo.Waypoint() != null)
					//recalculo la proxima posicion
				proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
			else 
				proximaPosicion = posicion;
			
			return proximaPosicion;	
		}
		else return posicion;
	}

}
