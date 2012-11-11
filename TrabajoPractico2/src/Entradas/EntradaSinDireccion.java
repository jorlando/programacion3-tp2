package Entradas;

import Utilitarios.Vector;


public class EntradaSinDireccion extends Entrada {

	public EntradaSinDireccion(Vector posicion, double ancho){
		this.posicion = posicion;
		this.ancho = ancho;
	}
	
	public boolean puntoPertenceALaEntrada(Vector vector) {
		return (vector.restarOtroVector(posicion).norma() <= ancho);
	}
	
	public boolean direccionCorrecta(Vector direccion){
		return true;
	}

}
