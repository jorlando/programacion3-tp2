package modelo.Aviones;

import java.util.ArrayList;
import java.util.Iterator;

import org.jdom2.Element;

import persistencia.guardable;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;
import modelo.Pistas.*;


public class Avion implements ObjetoPosicionable, ObjetoVivo, guardable
{
	private Vector posicion;
	private Trayectoria trayectoriaDeVuelo; 
	private EstrategiaAvion tipoDeAvion;
	private double velocidad;
	private int tamaño;
	private ObjetoDibujable miVista;
		
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
		return ((((this.posicion.restarOtroVector(otroAvion.posicion)).norma())-(this.getTamaño()/2 + otroAvion.getTamaño()/2)<0) && 
				tipoDeAvion.calcularChoqueCon(otroAvion));
	}
	
	public boolean verificarSiColicionaConOtro(ArrayList<Avion> otrosAviones)
	{
		Iterator<Avion> iteradorAviones = otrosAviones.listIterator();
		while( iteradorAviones.hasNext() ) {
	          Avion avionAVerificar = iteradorAviones.next();
	          // dentro de la lista de aviones recibida por parametro tambien esta el avion que verifica
	          if (avionAVerificar != this){
	        	  if( this.colisionaCon(avionAVerificar) ) return true;
	          }
		} 
	return false;
	}
	
	@Override
	public int getX(){
		return (int)this.posicion.getX();
	}
	
	@Override
	public int getY(){
		return (int)this.posicion.getY();
	}
	
	@Override
	public void vivir(){
		avanzar();
	}

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
	public void agregarPuntoATrayectoria(Vector unPunto){
		this.trayectoriaDeVuelo.AgregarWaypoint(unPunto);
	}
	
	public void limpiarTrayectoria(){
		this.trayectoriaDeVuelo.limpiar();
	}
	
	public String miImagen()
	{
		return tipoDeAvion.miImagen();
	}
	public double getVelocidad(){
		return this.velocidad;
	}
	
	public void guardarMiVista(ObjetoDibujable vistaRecibida)
	{
		this.miVista = vistaRecibida;
	}
	
	public ObjetoDibujable obtenerVista()
	{
		return this.miVista;
	}
	
	//utilizado para filtrar el avion Computarizado a la hora de capturar con el mouse
	public boolean trayectoriaModificable()
	{
		return this.tipoDeAvion.trayectoriaModificable();
	}

	public Element serializarXML()
	{
		Element elementoAvion = new Element("avion");
		elementoAvion.setAttribute("x", Double.toString(posicion.getX()));
		elementoAvion.setAttribute("y", Double.toString(posicion.getY()));
		elementoAvion.setAttribute("velocidad", Double.toString(velocidad));
		elementoAvion.setAttribute("tamanio", Double.toString(tamaño));
		elementoAvion.setAttribute("tipoDeAvion", tipoDeAvion.descripcionDeTipo());
		
		elementoAvion.getChildren().add(trayectoriaDeVuelo.serializarXML());
		
		return elementoAvion;		
	}
	
	public static Avion cargarDesdeXML(Element elementoAvion) {
		
		double posX = Double.parseDouble(elementoAvion.getAttributeValue("x"));
		double posY = Double.parseDouble(elementoAvion.getAttributeValue("y"));
		
		Trayectoria nuevaTrayectoria = Trayectoria.cargarDesdeXML(elementoAvion.getChild("trayectoria"));
		
		String descripcionTipo = elementoAvion.getAttributeValue("tipoDeAvion");
		
		return new Avion(new Vector(posX, posY), nuevaTrayectoria, determinarEstrategiaPorString(descripcionTipo));
	}

	private static EstrategiaAvion determinarEstrategiaPorString(String descripcionTipo) throws DescripcionAvionInvalida
	{
		switch(descripcionTipo)
		{
		case "AvionSimple":
			return new EstrategiaAvionSimple();
		case "AvionComputarizado":
			return new EstrategiaAvionComputarizado();
		case "AvionPesado":
			return new EstrategiaAvionPesado();
		case "AvionHelicoptero":
			return new EstrategiaAvionHelicoptero();
		default:
			throw new DescripcionAvionInvalida();
		}
	}
}
