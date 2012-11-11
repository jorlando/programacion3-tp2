package PistasTest;

import junit.framework.TestCase;
import Utilitarios.Vector;
import Pistas.Pista;
import Pistas.PistaSimpleEntrada;
import Aviones.Avion;
import Aviones.EstrategiaAvionSimple;



public class PistaSimpleEntradaTest extends TestCase{
	
	public void testAterrizarEnCondicionesPerfectas(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnPistaConAngulo0(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormales1(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormales2(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,-0.5), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite1(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(-3,-4), 2, 37);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(0,-4), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite2(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(0,1), 2, 45);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite3(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(0,1), 2, 90);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	
	public void testNoAterrizarConAnguloMayor(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 45);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testNoAterrizarFueraDeLaEntrada(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(1,0), new Vector(1,1), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testNoAterrizarConAnguloYPosicionMala(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(43,12), new Vector(-1,1), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	

}
