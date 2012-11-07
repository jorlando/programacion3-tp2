import Aviones.Avion;


public class Pista {
	
	private int cantidadEntradas; // solo para llevar un conteo, no sirve de mucho
	private Entrada[] entradas;
	
	public Pista (int c){
		entradas = new Entrada[c]; //habria que ver que tipo de entradas recibe, (Puede recibir cualquier entrada?)
		//le podriamos ya pasar la lista de entradas.
		cantidadEntradas = c;
	}
	
	public boolean calcularAterrizaje(Avion avion){
		int i = 1;
		//hay que hacer un for.
		if (entradas[i].direccionCorrecta(avion.obtenerDireccion()) == true) {
			if (entradas[i].puntoPertenceALaEntrada(avion.obtenerPosicion()) == true){
				return true;
			}
		}
		return false;
	}
}
