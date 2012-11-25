package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaConDireccion;


public class PistaDobleEntrada extends Pista {
	private Entrada entrada1;
	private Entrada entrada2;
	
	public PistaDobleEntrada(Vector posicion1, Vector posicion2, double ancho, double tolerancia){
		Vector direccion = posicion2.restarOtroVector(posicion1);
		entrada1 = new EntradaConDireccion(posicion1, ancho, direccion , tolerancia);
		entrada2 = new EntradaConDireccion(posicion2, ancho, direccion.multiplicarPorEscalar(-1), tolerancia);		
	}

	public boolean calcularAterrizaje(Avion avion) {
		
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (((entrada1.direccionCorrecta(direccionAvion) && entrada1.puntoPertenceALaEntrada(posicionAvion))) ||
			((entrada2.direccionCorrecta(direccionAvion) && entrada2.puntoPertenceALaEntrada(posicionAvion))));
	}
	
}
