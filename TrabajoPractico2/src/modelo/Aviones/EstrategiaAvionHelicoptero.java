package modelo.Aviones;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;

public class EstrategiaAvionHelicoptero implements EstrategiaAvion
{

	private static int tamaño = 10;
	
	public Vector avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
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
	
	public boolean puedeAterrizarEn(Pista unaPista){
		return unaPista.puedeAterrizarHelicoptero();
	}
	
	public boolean calcularChoqueCon(Avion unAvion){
		return true;
	}

	public int tamaño() 
	{
		return this.tamaño;
	}

	
}
