package AvionesTest;

import Utilitarios.Vector;
import Aviones.Avion;
import Aviones.Estrategia;
import junit.framework.TestCase;

	//  AvionTest será las pruebas de los metodos comunes a todos los aviones 
	//  (Aquellos implementados en la clase Abstracta Avion).
	//  Para la prueba se utilizara un miembro de la clase AvionSimple que es la mas
	//  directa de las relaciones de herencia.

public class AvionTest extends TestCase
{

	public void testAvionAvanzaSegunTrayectoriaYPosicionInicial()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, Estrategia.AvionSimple());
		
		unAvion.Avanzar();
		
		assertEquals(unAvion.obtenerPosicion(),posicionInicial.sumarOtroVector(unAvion.obtenerDireccion()));
	}

}
