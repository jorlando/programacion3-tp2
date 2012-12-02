package PistasTest;

import junit.framework.TestCase;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;
import modelo.Pistas.PistaSimpleEntrada;
import modelo.Aviones.Avion;
import modelo.Aviones.EstrategiaAvionSimple;



public class PistaSimpleEntradaTest extends TestCase{
	
	public void testAterrizarEnCondicionesPerfectas(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnPistaConAngulo0(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormales1(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormales2(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,-0.5), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite1(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(-3,-4), 2, 37);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(0,-4), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite2(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(0,1), 2, 45);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,1), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesNormalesAnguloLimite3(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(0,1), 2, 90);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	
	public void testNoAterrizarConAnguloMayor(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 45);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testNoAterrizarFueraDeLaEntrada(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(1,0), new Vector(1,1), new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testNoAterrizarConAnguloYPosicionMala(){
		Pista unaPista = new PistaSimpleEntrada(new Vector (0,0), new Vector(1,1), 2, 80);
		Avion unAvion = new Avion(new Vector(43,12), new Vector(-1,1), new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	

}
