package modelo.Utilitarios;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.jdom2.Element;

import persistencia.guardable;


public class Trayectoria implements guardable
{
	private Queue<Vector> waypoints;
	private Vector direccionAnterior;
	
	public Trayectoria(Iterator<Vector> direcciones)
	{
		this.waypoints = new LinkedList<Vector>();
		
		while(direcciones.hasNext())
			this.waypoints.offer(direcciones.next());
	}

	public Trayectoria(Vector unWaypoint)
	{
		this.waypoints = new LinkedList<Vector>();
		this.waypoints.offer(unWaypoint);
	}
	
	public Trayectoria() {
		this.waypoints = new LinkedList<Vector>();
	}

	public Vector Waypoint()
	{
		return this.waypoints.peek();
	}

	public Vector Direccion(Vector desdePosicion)
	{
		if (this.waypoints.peek() != null)
		{
			//La direccion sera la resta Waypoint - posicion desde normalizada
			if (this.waypoints.peek().esIgualA(desdePosicion))
				return this.direccionAnterior;
			else
			{		
				Vector aux = this.waypoints.peek().restarOtroVector(desdePosicion);
				
				this.direccionAnterior = aux.normalizar();
				return aux.normalizar();
			}
		}
		else 
			return new Vector(0,0);
	}
	

	protected Vector GetWaypoint()
	{
		return this.waypoints.remove();
	}
	
	public void AgregarWaypoint(Vector unWaypoint)
	{
		this.waypoints.offer(unWaypoint);
	}
	
	public void QuitarWaypoint()
	{
		this.waypoints.remove();
	}
	
	public void limpiar(){
		this.waypoints.clear();
	}

	public Element serializarXML() {
		
		Element elementoTrayectoria = new Element("trayectoria");
		
		if(direccionAnterior != null) //direccion anterior es null hasta que la trayectoria cambia de direccion.
		{	
			elementoTrayectoria.setAttribute("anteriorX", Double.toString(direccionAnterior.getX()));
			elementoTrayectoria.setAttribute("anteriorY", Double.toString(direccionAnterior.getY()));
		}
		
		Iterator<Vector> iterador = waypoints.iterator();
		
		int contador = 1;
		while(iterador.hasNext())
		{
			Vector auxWaypoint = iterador.next();
			Element auxChild = new Element("waypoint" + Integer.toString(contador));  
			
			auxChild.setAttribute("x", Double.toString(auxWaypoint.getX()));
			auxChild.setAttribute("y", Double.toString(auxWaypoint.getY()));
			
			elementoTrayectoria.addContent(auxChild);
			contador++;
		}
		return elementoTrayectoria;
	}

	public static Trayectoria cargarDesdeXML(Element elementoTrayectoria)
	{
		Trayectoria nuevaTrayectoria = new Trayectoria();
				
		if(elementoTrayectoria.hasAttributes())
		{
			nuevaTrayectoria.direccionAnterior = new Vector(Double.parseDouble(elementoTrayectoria.getAttributeValue("anteriorX")), Double.parseDouble(elementoTrayectoria.getAttributeValue("anteriorY")));
		}
			
		Iterator <Element> iterador = elementoTrayectoria.getChildren().iterator();
		while (iterador.hasNext())
		{
			Element auxElement = iterador.next();
			Vector auxVector = new Vector(Double.parseDouble(auxElement.getAttributeValue("x")), Double.parseDouble(auxElement.getAttributeValue("y")));
			nuevaTrayectoria.AgregarWaypoint(auxVector);
		}
		
		return nuevaTrayectoria;
	}

}
