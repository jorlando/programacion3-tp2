package Pistas;

import Utilitarios.Vector;
import Aviones.Avion;
import Entradas.Entrada;
import Entradas.EntradaConDireccion;


public class PistaSimpleEntrada implements Pista {

	private Entrada entrada;
	
	public PistaSimpleEntrada(Vector posicion, Vector direccion, double ancho, double tolerancia){
		entrada = new EntradaConDireccion(posicion,ancho,direccion,tolerancia);
	}
	
	public boolean calcularAterrizaje(Avion avion) {
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (entrada.puntoPertenceALaEntrada(posicionAvion) && entrada.direccionCorrecta(direccionAvion));
	}

}
