package modelo.Entradas;

import modelo.Utilitarios.Vector;

public abstract class Entrada {
	
	protected Vector posicion;
	protected double ancho;
	
	public abstract boolean puntoPertenceALaEntrada(Vector vector);
	public abstract boolean direccionCorrecta(Vector direccion);

}
