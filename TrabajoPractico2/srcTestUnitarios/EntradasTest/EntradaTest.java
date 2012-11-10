package EntradasTest;


import Utilitarios.Vector;
import Aviones.Avion;
import Aviones.Estrategia;
import Entradas.EntradaConDireccion;
import junit.framework.TestCase;

public class EntradaTest extends TestCase {
	
	EntradaConDireccion entrada;
	Avion avion1;
	
	public void setUp(){
		entrada= new EntradaConDireccion(new Vector(1,2) , 2 , new Vector(2,1) , 45 );
		avion1 = new Avion(new Vector(1,2),new Vector (2,1), 1, Estrategia.AvionSimple());
	}
	
	public void testEntradaPunto12PerteneceAEntrada() {
		Vector unPunto = new Vector(1,2);
		assertTrue(entrada.puntoPertenceALaEntrada(unPunto));	
	}
	
	public void testEntradaPunto20PerteneceAEntrada() {
		EntradaConDireccion entrada2 = new EntradaConDireccion(new Vector(1,2) , 3 , new Vector(2,1) , 45);
		Vector unPunto = new Vector(2,0);
		assertTrue(entrada2.puntoPertenceALaEntrada(unPunto));	
	}
	
	public void testEntradaPuntoPerteneceAEntradaPeroSePasaDelAncho() {
		Vector unPunto = new Vector(3,-2);
		assertFalse(entrada.puntoPertenceALaEntrada(unPunto));	
	}
	
	public void testEntradaPuntoNoPerteneceAEntrada() {
		Vector unPunto = new Vector(1,3);
		assertFalse(entrada.puntoPertenceALaEntrada(unPunto));	
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
