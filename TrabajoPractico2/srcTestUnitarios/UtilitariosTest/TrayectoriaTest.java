package UtilitariosTest;

import java.util.LinkedList;
import java.util.Queue;

import persistencia.Archivador;

import modelo.Utilitarios.Trayectoria;
import modelo.Utilitarios.Vector;

import junit.framework.TestCase;


public class TrayectoriaTest extends TestCase 
{

	public Queue<Vector> unasDirecciones;
	
	@Override
	protected void setUp()
	{
		unasDirecciones = new LinkedList<Vector>();
		
	}
	
	public void testWaypointCargadoCorrectamente()
	{
		unasDirecciones.offer(new Vector(1,2));
		
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones.iterator());
		
		unaTrayectoria.Waypoint().esIgualA(new Vector(1,2));
	}
	
	public void testDireccionEsUnVersor() 
	{
		unasDirecciones.offer(new Vector(0,2));
		unasDirecciones.offer(new Vector(1,0));
		
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones.iterator());
				
		Vector versorDireccion = unaTrayectoria.Direccion(new Vector(0,0));
		
		assertTrue(versorDireccion.esIgualA(new Vector(0,1)));
	}
	
	public void testEliminarDireccion()
	{
		unasDirecciones.offer(new Vector(0,2));
		unasDirecciones.offer(new Vector(1,1));
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones.iterator());
	
		unaTrayectoria.QuitarWaypoint();
		
		assertTrue(unaTrayectoria.Waypoint().esIgualA(new Vector(1,1)));
	}

	public void testPersistencia()
	{
		String pathArchivo = "srcTestUnitarios//UtilitariosTest//pruebaTrayectoria.xml";
		unasDirecciones.offer(new Vector(1,2));	
		unasDirecciones.offer(new Vector(2,3));
		Trayectoria unaTrayectoria = new Trayectoria(unasDirecciones.iterator());
		
		Archivador.guardar(unaTrayectoria, pathArchivo);
		
		Trayectoria nuevaTrayectoria = Archivador.cargarTrayectoria(pathArchivo);
		
		assertTrue(nuevaTrayectoria.Waypoint().esIgualA(new Vector(1,2))); // Verifico que la cabecera se mantenga
		
	}
}
