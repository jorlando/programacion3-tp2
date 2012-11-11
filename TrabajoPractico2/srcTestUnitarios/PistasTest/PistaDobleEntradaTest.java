package PistasTest;

import junit.framework.TestCase;
import Utilitarios.Vector;
import Pistas.Pista;
import Pistas.PistaDobleEntrada;
import Aviones.Avion;
import Aviones.EstrategiaAvionSimple;

public class PistaDobleEntradaTest extends TestCase{
	
	public void testAterrizarEnCondicionesPerfectas(){
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(0,38), 2, 0);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(0,1), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testAterrizarEnCondicionesPerfectas2(){
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 0);
		Avion unAvion = new Avion(new Vector(1,1), new Vector(-1,-1), 2, new EstrategiaAvionSimple());
		assertTrue(unaPista.calcularAterrizaje(unAvion));
	}
	
	public void testNoAterrizarConDireccionContrariaSobreUnaEntrada1(){
		Pista unaPista = new PistaDobleEntrada(new Vector (1,1), new Vector(5,2), 1, 5);
		Avion unAvion = new Avion(new Vector(5,2), new Vector(4,1), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
		
	}
	
	public void testNoAterrizarConDireccionContrariaSobreUnaEntrada2(){
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(0,38), 2, 30);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(0,-1), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	
	
	public void testNoAterrizarConAnguloMayor(){
		Pista unaPista = new PistaDobleEntrada(new Vector (0,0), new Vector(1,1), 2, 45);
		Avion unAvion = new Avion(new Vector(0,0), new Vector(1,0), 2, new EstrategiaAvionSimple());
		assertFalse(unaPista.calcularAterrizaje(unAvion));
	}
	

}
