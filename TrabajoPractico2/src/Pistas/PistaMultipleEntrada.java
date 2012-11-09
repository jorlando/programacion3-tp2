package Pistas;

import Aviones.Avion;
import Entradas.Entrada;


public class PistaMultipleEntrada extends Pista {
	//no esta lista todavia.
	private int cantidadEntradas;
	private Entrada[] entradas;
	
	public PistaMultipleEntrada (int c){
		entradas = new Entrada[c];//hay que ver como agregamos las entradas.
		cantidadEntradas = c;
	}
	
	public boolean calcularAterrizaje(Avion avion){
		for (int i = 0;i<cantidadEntradas;i++){
			if (entradas[i].direccionCorrecta(avion.obtenerDireccion()) == true) {
				if (entradas[i].puntoPertenceALaEntrada(avion.obtenerPosicion()) == true){
					return true;
				}
			}
		}
		//si sale del ciclo significa que no puede entrar en ninguna de las entradas de la pista.
		return false;
	}
}
