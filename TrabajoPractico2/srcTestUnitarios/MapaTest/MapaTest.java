package MapaTest;

import java.util.ArrayList;

import junit.framework.TestCase;
import Aviones.Avion;
import Aviones.EstrategiaAvionPesado;
import Aviones.EstrategiaAvionSimple;
import Mapa.Mapa;
import Pistas.Pista;
import Pistas.PistaDobleEntrada;
import Utilitarios.Vector;

public class MapaTest extends TestCase {

	public void testMapaAgregarPista()
	{
		Mapa unMapa= new Mapa(50,50);
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		unMapa.agregarPista(unaPista);
		ArrayList<Pista> pistas = unMapa.obtenerPistas();
		assertTrue(pistas.size() == 1);
	}
	
	public void testMapaAgregarAviones()
	{
		Mapa unMapa= new Mapa(50,50);
		
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionSimple());
		
		Vector otraPosicionInicial = new Vector(2,0);
		Avion otroAvion = new Avion(otraPosicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		unMapa.agregarAvion(unAvion);
		unMapa.agregarAvion(otroAvion);
		ArrayList<Avion> aviones = unMapa.obtenerAviones();
		assertTrue(aviones.size() == 2);
	}
	
	public void testMapaColicionanAviones()
	{
		Mapa unMapa= new Mapa(50,50);
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionSimple());
		
		Vector otraPosicionInicial = new Vector(1,0);	//A esa distancia chocan
		Avion avionAChocar = new Avion(otraPosicionInicial, direccionInicial, 1, new EstrategiaAvionSimple());
		
		unMapa.agregarAvion(unAvion);
		unMapa.agregarAvion(avionAChocar);
		assertTrue(unMapa.verificarColisiones());
	}
	
	public void testMapaAvionAterriza(){
		Mapa unMapa= new Mapa(50,50);
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		Avion unAvion = new Avion(new Vector(1,1), new Vector(-1,-1), 2, new EstrategiaAvionSimple());
		
		unMapa.agregarPista(unaPista);
		unMapa.agregarAvion(unAvion);
		unMapa.aterrizarAviones();
		
		ArrayList<Avion> aviones = unMapa.obtenerAviones();
		assertTrue(aviones.size() == 0);
	}
	
	public void testMapaAvanzarAviones()
	{
		Mapa unMapa= new Mapa(50,50);
		Vector posicionInicial = new Vector(1,0);
		Vector direccionInicial = new Vector(2,0);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionSimple());
		
		unMapa.agregarAvion(unAvion);
		unMapa.moverAviones();
		unMapa.moverAviones();
		
		assertTrue(unAvion.obtenerPosicion().getX() == 3.0 && 
				   unAvion.obtenerPosicion().getY() == 0.0 );
	}
	
	

}