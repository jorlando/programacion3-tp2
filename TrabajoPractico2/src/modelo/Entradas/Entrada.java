package modelo.Entradas;

import modelo.Utilitarios.Vector;
import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Entrada implements Posicionable {
	
	protected Vector posicion;
	protected double ancho;
	
	public abstract boolean puntoPertenceALaEntrada(Vector vector);
	public abstract boolean direccionCorrecta(Vector direccion);
	public int getX(){
		return (int)this.posicion.getX();
	}
	public int getY(){
		return (int)this.posicion.getY();
	}

}
