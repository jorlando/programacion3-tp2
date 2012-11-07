package Utilitarios;

import java.util.Queue;
import java.util.Stack;

public class Trayectoria
{
	private Queue<Vector> waypoints;

	public Trayectoria(Queue<Vector> unasDirecciones)
	{
		this.waypoints = unasDirecciones;
	}

	public Vector Waypoint()
	{
		return this.waypoints.peek();
	}

	public Vector Direccion()
	{
		Vector aux = new Vector(this.waypoints.peek());
		
		return aux.normalizar();
	}

	public void WaypointAlcanzado()
	{
		this.waypoints.remove();
	}

}
