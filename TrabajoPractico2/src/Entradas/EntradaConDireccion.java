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
		if (vector.restarOtroVector(posicion).norma() < ancho){
			double y = (direccionEntrada.obtenerPerpendicular().pendiente()*(vector.getX()-posicion.getX()))+posicion.getY(); //esto es la formula de la recta que pasa por un punto.
			if (y == vector.getY()) return true;
		}
		return false;
	}
	
	public boolean direccionCorrecta(Vector direccion){
		double angulo = Math.abs(Math.toDegrees(direccion.anguloFormadoCon(direccionEntrada)));
		if (angulo <= tolerancia) return true;
		return false;
	}

}
