package modelo.Entradas;

import modelo.Utilitarios.Vector;


public class EntradaSinDireccion extends Entrada {

	public EntradaSinDireccion(Vector posicion, double ancho){
		this.posicion = posicion;
		this.ancho = ancho;
	}
	
	@Override
	public boolean puntoPertenceALaEntrada(Vector vector, double velocidadAvion) {
		if (velocidadAvion > ancho){
			return (vector.restarOtroVector(posicion).norma() <= velocidadAvion);//nose si esta del todo bien
		}
		return (vector.restarOtroVector(posicion).norma() <= ancho);
	}
	
	@Override
	public boolean direccionCorrecta(Vector direccion){
		return true;
	}

}
