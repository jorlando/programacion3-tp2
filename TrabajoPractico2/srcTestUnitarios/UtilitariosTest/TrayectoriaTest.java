package UtilitariosTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;

import junit.framework.TestCase;


public class TrayectoriaTest extends TestCase 
{

	public Queue<Vector> unasDirecciones;
	
	protected void setUp()
	{
		unasDirecciones = new LinkedList<Vector>();
		
	}
	
	public void testWaypointCargadoCorrectamente()
	{
		unasDirecciones.offer(new Vector(1,2));
		
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones);
		
		unaTrayectoria.Waypoint().esIgualA(new Vector(1,2));
	}
	
	public void testDireccionEsUnVersor() 
	{
		unasDirecciones.offer(new Vector(0,2));
		unasDirecciones.offer(new Vector(1,0));
		
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones);
				
		Vector versorDireccion = unaTrayectoria.Direccion();
		
		assertTrue(versorDireccion.esIgualA(new Vector(0,1)));
	}
	
	public void testEliminarDireccion()
	{
		unasDirecciones.offer(new Vector(0,2));
		unasDirecciones.offer(new Vector(1,1));
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones);
	
		unaTrayectoria.WaypointAlcanzado();
		
		assertTrue(unaTrayectoria.Waypoint().esIgualA(new Vector(1,1)));
	}

}
