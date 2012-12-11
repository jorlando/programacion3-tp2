package modelo.Aviones;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;

public class EstrategiaAvionHelicoptero implements EstrategiaAvion
{

	private static int tamaño = 10;
	private static String rutaImagen="recursos/imagenes/helicoptero2.png";
	
	public Vector avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
	{
		if(trayectoriaDeVuelo.Waypoint() != null)
		{
			Vector distanciaActual = trayectoriaDeVuelo.Waypoint().restarOtroVector(posicion);
			
			double distanciaAlWaypoint = distanciaActual.norma();
			
			Vector proximaPosicion = posicion.sumarOtroVector(trayectoriaDeVuelo.Direccion(posicion).multiplicarPorEscalar(velocidad));
			Vector proximaDistancia = trayectoriaDeVuelo.Waypoint().restarOtroVector(proximaPosicion);
			
			double proximaDistanciaAlWaypoint = trayectoriaDeVuelo.Waypoint().restarOtroVector(proximaPosicion).norma();
			
			
			boolean mismoSentido = (distanciaActual.normalizar().esIgualA(proximaDistancia.normalizar())); //Si me acerco pero cambie de sentido es que me pase del waypoint
			
			//Si me voy a acercar al waypoint sigo avanzando
			if(distanciaAlWaypoint >= proximaDistanciaAlWaypoint && mismoSentido)
			{
			//	System.out.println(proximaPosicion.getX() + "--" + proximaPosicion.getY());
				return proximaPosicion;
			}
			//Sino cambio de direccion, y si no hay sigo derecho
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

	public String miImagen()
	{
		return rutaImagen;
	}	
	
	public int tamaño() 
	{
		return tamaño;
	}
	
	public boolean trayectoriaModificable()
	{
		return true;
	}

	
}
