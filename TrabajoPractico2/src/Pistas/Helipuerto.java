package Pistas;

import Utilitarios.Vector;
import Aviones.Avion;
import Entradas.Entrada;
import Entradas.EntradaSinDireccion;

public class Helipuerto implements Pista {
	private Entrada entrada;
	
	public Helipuerto (Vector posicion, double ancho){
		entrada = new EntradaSinDireccion(posicion,ancho);
	}
	
	public boolean calcularAterrizaje(Avion avion){
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (entrada.puntoPertenceALaEntrada(posicionAvion) && entrada.direccionCorrecta(direccionAvion));
	}

}
