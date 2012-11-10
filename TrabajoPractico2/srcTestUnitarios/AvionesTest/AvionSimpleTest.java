package AvionesTest;

import Utilitarios.Vector;
import Aviones.Avion;
import Aviones.Estrategia;
import junit.framework.TestCase;

	//  AvionTest ser� las pruebas de los metodos comunes a todos los aviones 
	//  (Aquellos implementados en la clase Abstracta Avion).
	//  Para la prueba se utilizara un miembro de la clase AvionSimple que es la mas
	//  directa de las relaciones de herencia.

public class AvionSimpleTest extends TestCase
{

	public void testAvionAvanzaSegunTrayectoriaYPosicionInicial()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, Estrategia.AvionSimple());
		
		unAvion.avanzar();
		
		double dx = unAvion.obtenerPosicion().getX() - posicionInicial.sumarOtroVector(unAvion.obtenerDireccion()).getX();
		double dy = unAvion.obtenerPosicion().getY() - posicionInicial.sumarOtroVector(unAvion.obtenerDireccion()).getY();
		double deltaPermitido = 0.01;
		
		if(dx >= deltaPermitido || dx <= deltaPermitido*(-1))
			fail();
		if(dy >= deltaPermitido || dy <= deltaPermitido*(-1))
			fail();
	}

	public void testAvionContinuaEnLineaRecta()
	{
		Vector posicionInicial = new Vector(1,0);
		Vector direccionInicial = new Vector(2,0);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, Estrategia.AvionSimple());
		
		unAvion.avanzar();
		unAvion.avanzar();
		
		assertTrue(unAvion.obtenerPosicion().getX() == 3.0 && 
				   unAvion.obtenerPosicion().getY() == 0.0 );
	}
}
