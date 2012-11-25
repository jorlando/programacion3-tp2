package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaConDireccion;


public class PistaSimpleEntrada extends Pista {
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
