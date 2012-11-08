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
		
		double dx = unAvion.obtenerPosicion().getX() - posicionInicial.sumarOtroVector(unAvion.obtenerDireccion()).getX();
		double dy = unAvion.obtenerPosicion().getY() - posicionInicial.sumarOtroVector(unAvion.obtenerDireccion()).getY();
		double deltaPermitido = 0.01;
		
		if(dx >= deltaPermitido || dx <= deltaPermitido*(-1))
			fail();
		if(dy >= deltaPermitido || dy <= deltaPermitido*(-1))
			fail();
	}

}
