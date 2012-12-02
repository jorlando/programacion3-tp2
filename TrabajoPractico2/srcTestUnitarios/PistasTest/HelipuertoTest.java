package PistasTest;

import junit.framework.TestCase;
import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;
import modelo.Pistas.Helipuerto;
import modelo.Aviones.Avion;
import modelo.Aviones.EstrategiaAvionHelicoptero;


public class HelipuertoTest extends TestCase {

	public void testAterrizarHelicopteroEnHelipuerto(){
		Pista unHelipuerto = new Helipuerto(new Vector(2,1),3);
		Avion unHelicoptero = new Avion(new Vector(-0.99,1), new Vector(12,83), 2, new EstrategiaAvionHelicoptero());
		assertTrue(unHelipuerto.calcularAterrizaje(unHelicoptero));
	}
	
	public void testAterrizarHelicopteroEnCentroDeHelipuerto(){
		Pista unHelipuerto = new Helipuerto(new Vector(2,1),3);
		Avion unHelicoptero = new Avion(new Vector(2,1), new Vector(0,0), 2, new EstrategiaAvionHelicoptero());
		assertTrue(unHelipuerto.calcularAterrizaje(unHelicoptero));
	}
	
	public void testAterrizarHelicopteroEnHelipuertoConTamanio0(){
		Pista unHelipuerto = new Helipuerto(new Vector(2,1),0);
		Avion unHelicoptero = new Avion(new Vector(2,1), new Vector(0,0), 2, new EstrategiaAvionHelicoptero());
		assertTrue(unHelipuerto.calcularAterrizaje(unHelicoptero));
	}
	
	public void testAterrizarHelicopteroFueraDeZona(){
		Pista unHelipuerto = new Helipuerto(new Vector(2,1),2);
		Avion unHelicoptero = new Avion(new Vector(5,3), new Vector(1,1), 2, new EstrategiaAvionHelicoptero());
		assertFalse(unHelipuerto.calcularAterrizaje(unHelicoptero));
	}
}