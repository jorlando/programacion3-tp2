package UtilitariosTest;

import modelo.Utilitarios.Vector;
import junit.framework.TestCase;

public class VectorTest extends TestCase{
	
	Vector vector12;
	Vector vector23;
	Vector vector35;
	Vector vector11;
	Vector vector10;
	Vector vector60;
	Vector vectorm21;
	
	@Override
	public void setUp (){
		
		vector12 = new Vector(1,2);
		vector23 = new Vector(2,3);
		vector35 = new Vector(3,5);
		vector11 = new Vector(1,1);
		vector10 = new Vector(1,0);
		vector60 = new Vector(6,0);
		vectorm21 = new Vector(-2,1);
		
	}
	
	public void testEvaluarVector(){
		Vector vector = new Vector(3.2,5.4);
		assertTrue((vector.getX()==3.2) && (vector.getY()==5.4));
	}
	
	public void testSumarVector(){
		Vector vectorR = vector12.sumarOtroVector(vector23);
		assertTrue(vectorR.esIgualA(vector35));
	}
	
	public void testRestarVector(){
		Vector vectorR = vector23.restarOtroVector(vector12);
		assertTrue(vectorR.esIgualA(vector11));
	}
	
	public void testMultiplicarVector(){
		Vector vectorR = vector10.multiplicarPorEscalar(6);
		assertTrue(vectorR.esIgualA(vector60));
	}
	
	public void testNormaVector(){
		double norma = vector10.norma();
		assertTrue(norma==1);
		
	}
	
	public void testNormalizarVector11(){
		Vector vectorNormalizado = vector10.normalizar();
		assertTrue(vectorNormalizado.esIgualA(vector10));
	}
	
	public void testNormalizarVector60(){
		Vector vectorNormalizado = vector60.normalizar();
		assertTrue(vectorNormalizado.esIgualA(vector10));
	}
	
	public void testObtenerPerpendicular(){
		Vector vectorPerpendicular = vector12.obtenerPerpendicular();
		assertTrue(vectorPerpendicular.esIgualA(vectorm21));
	}
	
	public void testProductoEscalar(){
		double resultado = vector12.productoEscalar(vectorm21);
		assertTrue(resultado == 0);
	}
	
	public void testObtenerAngulo10con60(){
		double resultado = vector10.anguloFormadoCon(vector60);
		assertTrue (resultado==0);
	}
	
	public void testObtenerAngulo12conm21(){
		double resultado = Math.toDegrees(vector12.anguloFormadoCon(vectorm21));
		assertTrue (resultado==90);
	}
	
	
}
