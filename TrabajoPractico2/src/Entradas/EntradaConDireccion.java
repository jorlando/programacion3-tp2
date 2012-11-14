package Entradas;

import Utilitarios.Vector;


public class EntradaConDireccion extends Entrada {
	
	private Vector direccionEntrada;
	private double tolerancia; //grados.
		
	public EntradaConDireccion(Vector posicion, double ancho, Vector direccion, double tol){
		this.posicion = posicion;
		this.ancho=ancho;
		direccionEntrada= direccion;
		tolerancia = tol;
	}
	
	public boolean puntoPertenceALaEntrada(Vector vector){
		Vector v1 = posicion;
		Vector v2 = posicion.sumarOtroVector(direccionEntrada.obtenerPerpendicular());
		if (v1.getX() == v2.getX()){ //si son iguales falla (division por 0)
			return (vector.restarOtroVector(posicion).norma() <= ancho) && (vector.getX() == v1.getX());
		}
		double y = ((v2.getY()-v1.getY())/(v2.getX()-v1.getX()))*(vector.getX()-v1.getX())+v1.getY();
		return (vector.restarOtroVector(posicion).norma() <= ancho) && (y==vector.getY());
			
	}
	
	public boolean direccionCorrecta(Vector direccion){
		return (tolerancia >= Math.abs(Math.toDegrees(direccion.anguloFormadoCon(direccionEntrada))));
	}

}
