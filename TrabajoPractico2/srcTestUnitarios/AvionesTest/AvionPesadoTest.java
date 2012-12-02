package testUnitarios.AvionesTest;


import java.util.ArrayList;
import modelo.Aviones.Avion;
import modelo.Aviones.EstrategiaAvionPesado;
import modelo.Utilitarios.Vector;

import junit.framework.TestCase;

public class AvionPesadoTest extends TestCase {

	public void testAvionAvanzaSegunTrayectoriaYPosicionInicial()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
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
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		unAvion.avanzar();
		unAvion.avanzar();
		
		assertTrue(unAvion.obtenerPosicion().getX() == 3.0 && 
				   unAvion.obtenerPosicion().getY() == 0.0 );
	}
	
	public void testAvionColisiona()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		Vector otraPosicionInicial = new Vector(1,0);	//A esa distancia chocan
		Avion avionAChocar = new Avion(otraPosicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		assertTrue(unAvion.colisionaCon(avionAChocar));
	}
	
	public void testAvionNoColisiona()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		Vector otraPosicionInicial = new Vector(2,0);	//Lejos, no deberia chocar
		Avion avionAChocar = new Avion(otraPosicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		assertFalse(unAvion.colisionaCon(avionAChocar));
	}
	
	public void testAvionNoColisionaConsigoMismo()
	{
		Vector posicionInicial = new Vector(0,0);
		Vector direccionInicial = new Vector(1,2);
		Avion unAvion = new Avion(posicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		Vector otraPosicionInicial = new Vector(4,0);	//Lejos, no deberia chocar
		Avion avionAChocar = new Avion(otraPosicionInicial, direccionInicial, 1, new EstrategiaAvionPesado());
		
		ArrayList<Avion> todosLosAviones = new ArrayList<Avion>();
		todosLosAviones.add(avionAChocar);
		todosLosAviones.add(unAvion);
		
		assertFalse(unAvion.verificarSiColicionaConOtro(todosLosAviones));
		
	}

}
