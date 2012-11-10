package Utilitarios;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class Trayectoria
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
	
	public Vector Waypoint()
	{
		return this.waypoints.peek();
	}

	public Vector Direccion(Vector desdePosicion)
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

}
