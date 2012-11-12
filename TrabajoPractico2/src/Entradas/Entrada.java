package Entradas;

import Utilitarios.Vector;

public abstract class Entrada {
	
	protected Vector posicion;
	protected double ancho;
	
	protected abstract boolean puntoPertenceALaEntrada(Vector vector);
	protected abstract boolean direccionCorrecta(Vector direccion);

}
