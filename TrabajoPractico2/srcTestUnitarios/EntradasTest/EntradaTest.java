package EntradasTest;


import modelo.Utilitarios.Vector;
import modelo.Aviones.Avion;
import modelo.Aviones.EstrategiaAvionSimple;
import modelo.Entradas.EntradaConDireccion;
import junit.framework.TestCase;

public class EntradaTest extends TestCase {
	
	EntradaConDireccion entrada;
	Avion avion1;
	
	@Override
	public void setUp(){
		entrada= new EntradaConDireccion(new Vector(1,2) , 2 , new Vector(2,1) , 45 );
		avion1 = new Avion(new Vector(1,2),new Vector (2,1), new EstrategiaAvionSimple());
	}
	
	public void testEntradaPunto12PerteneceAEntrada() {
		Vector unPunto = new Vector(1,2);
		assertTrue(entrada.puntoPertenceALaEntrada(unPunto,0));	
	}
	
	public void testEntradaPunto20PerteneceAEntrada() {
		EntradaConDireccion entrada2 = new EntradaConDireccion(new Vector(1,2) , 3 , new Vector(2,1) , 45);
		Vector unPunto = new Vector(2,0);
		assertTrue(entrada2.puntoPertenceALaEntrada(unPunto,0));	
	}
	
	public void testEntradaPuntoPerteneceAEntradaPeroSePasaDelAncho() {
		Vector unPunto = new Vector(3,-2);
		assertFalse(entrada.puntoPertenceALaEntrada(unPunto,0));	
	}
	
	public void testEntradaPuntoNoPerteneceAEntrada() {
		Vector unPunto = new Vector(1,5);
		assertFalse(entrada.puntoPertenceALaEntrada(unPunto,0));	
	}
	
	public void testEntradaDireccion10Correcta() {
		EntradaConDireccion entrada2 = new EntradaConDireccion(new Vector (0,0) , 3 , new Vector(1,0) , 45);
		Vector unaDireccion = new Vector(1,0);
		assertTrue(entrada2.direccionCorrecta(unaDireccion));	
	}
	public void testEntradaDireccion11Correcta() {
		EntradaConDireccion entrada2 = new EntradaConDireccion(new Vector (0,0) , 3 , new Vector(1,0) , 45);
		Vector unaDireccion = new Vector(1,0.5);
		assertTrue(entrada2.direccionCorrecta(unaDireccion));	
	}

}
