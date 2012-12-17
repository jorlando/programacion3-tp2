package MapaTest;

import java.util.ArrayList;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

import Excepciones.ImposibleCalcularPosicion;

import junit.framework.TestCase;
import modelo.Aviones.*;
import modelo.Mapa.Mapa;
import modelo.Pistas.*;
import modelo.Utilitarios.Vector;

public class MapaTest extends TestCase {
	private Mapa unMapa;
	private GameLoop gameLoop;
	protected void setUp(){
		gameLoop = new GameLoop(50,(SuperficieDeDibujo) new SuperficiePanel());
		unMapa = new Mapa(50,50,gameLoop);		
	}

	public void testMapaAgregarPista()
	{
		
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		unMapa.agregarPista(unaPista);
		ArrayList<Pista> pistas = unMapa.obtenerPistas();
		assertTrue(pistas.size() == 1);
	}
	
	public void testMapaAgregarAviones()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, new EstrategiaAvionSimple());
		
		Vector otraPosicionInicial = new Vector(2,0);
		Avion otroAvion = new Avion(otraPosicionInicial, direccionInicial, new EstrategiaAvionPesado());
		
		unMapa.agregarAvion(unAvion);
		unMapa.agregarAvion(otroAvion);
		ArrayList<Avion> aviones = unMapa.obtenerAviones();
		assertTrue(aviones.size() == 2);
	}
	
	public void testMapaColicionanAviones()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, new EstrategiaAvionSimple());
		
		Vector otraPosicionInicial = new Vector(1,0);	//A esa distancia chocan
		Avion avionAChocar = new Avion(otraPosicionInicial, direccionInicial, new EstrategiaAvionSimple());
		
		unMapa.agregarAvion(unAvion);
		unMapa.agregarAvion(avionAChocar);
		assertTrue(unMapa.verificarColisiones());
	}
	
	public void testMapaAvionAterriza(){
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		Avion unAvion = new Avion(new Vector(1,1), new Vector(-1,-1), new EstrategiaAvionSimple());
		
		unMapa.agregarPista(unaPista);
		unMapa.agregarAvion(unAvion);
		unMapa.aterrizarAviones();
		
		ArrayList<Avion> aviones = unMapa.obtenerAviones();
		assertTrue(aviones.size() == 0);
	}
	
	public void testMapaAvanzarAviones()
	{
		Vector posicionInicial = new Vector(1,0);
		Vector direccionInicial = new Vector(2,0);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, new EstrategiaAvionSimple());
		
		unMapa.agregarAvion(unAvion);
		unMapa.moverAviones();
		unMapa.moverAviones();
		
		assertTrue(unAvion.obtenerPosicion().getX() == 3.0 && 
				   unAvion.obtenerPosicion().getY() == 0.0 );
	}
	public void testMapaObtenerPosicion(){
		Mapa otroMapa = new Mapa(10,10,gameLoop);
		Vector unVector = new Vector(0,0);
		try{
			unVector = otroMapa.obtenerPosicionLibre();
		}
		catch (ImposibleCalcularPosicion ex){
			assertTrue(true);
		}
		assertTrue ((unVector.getX() <= 10) && (unVector.getY() <= 10));
	}
	
	
	

}
