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
		return (vector.restarOtroVector(posicion).norma() <= ancho) &&
				( vector.getY() == (direccionEntrada.obtenerPerpendicular().pendiente()*(vector.getX()-posicion.getX()))+posicion.getY()); //esto es la formula de la recta que pasa por un punto.
	}
	
	public boolean direccionCorrecta(Vector direccion){
		return (tolerancia >= Math.abs(Math.toDegrees(direccion.anguloFormadoCon(direccionEntrada))));
	}

}
