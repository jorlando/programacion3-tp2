package modelo.Aviones;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;

public class EstrategiaAvionPesado implements EstrategiaAvion
{

	private static int tama�o = 30;
	private static String rutaImagen="recursos/imagenes/AvionPesado2.png";
	

	@Override
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
	
		return proximaPosicion;	
	}
	
	@Override
	public boolean puedeAterrizarEn(Pista unaPista){
		return unaPista.puedeAterrizarAvionPesado();
	}
	
	@Override
	public boolean calcularChoqueCon(Avion unAvion){
		return true;
	}
	
	@Override
	public String miImagen()
	{
		return rutaImagen;
	}

	@Override
	public int tama�o() 
	{
		return tama�o;
	}
	
	@Override
	public boolean trayectoriaModificable()
	{
		return true;
	}

	@Override
	public String descripcionDeTipo() {
		
		return "AvionPesado";
	}


}
