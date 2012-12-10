package modelo.Aviones;

import modelo.Pistas.Pista;
import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;

public class EstrategiaAvionSimple implements EstrategiaAvion
{
	private static int tama�o = 20;
	private static String rutaImagen="recursos/imagenes/avionSimple2.png";
	
	public Vector avanzar(Vector posicion, double velocidad, Trayectoria trayectoriaDeVuelo)
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

	public int tama�o() 
	{
		return this.tama�o;
	}
	
	public boolean trayectoriaModificable()
	{
		return true;
	}

	
}
