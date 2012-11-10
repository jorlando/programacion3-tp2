package Entradas;

import Utilitarios.Vector;


public class EntradaSinDireccion extends Entrada {

	public EntradaSinDireccion(Vector posicion, double ancho){
		this.posicion = posicion;
		this.ancho = ancho;
	}
	
	public boolean puntoPertenceALaEntrada(Vector vector) {
		if (vector.restarOtroVector(posicion).norma() < ancho) return true;
		return false;
	}
	
	public boolean direccionCorrecta(Vector direccion){
		return true;
	}

}
