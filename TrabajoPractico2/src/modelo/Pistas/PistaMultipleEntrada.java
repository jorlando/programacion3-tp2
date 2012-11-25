package modelo.Pistas;

import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import java.util.ArrayList;
import java.util.Iterator;


public class PistaMultipleEntrada extends Pista {
	private ArrayList<Entrada> entradas;
	
	public PistaMultipleEntrada (ArrayList<Entrada> entradasNuevas){
		entradas = new ArrayList<Entrada>(entradasNuevas);//no estoy seguro si funciona.
	}
	
	public boolean calcularAterrizaje(Avion avion){
		// hay que probar a ver si anda
		Iterator<Entrada> it = entradas.iterator();
		Entrada entradaActual;
		while (it.hasNext()){
			entradaActual = it.next();
			if (entradaActual.direccionCorrecta(avion.obtenerDireccion()) && entradaActual.puntoPertenceALaEntrada(avion.obtenerPosicion())) return true;
		}
		//si sale del ciclo significa que no puede entrar en ninguna de las entradas de la pista.
		return false;
	}
}
