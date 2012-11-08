
public class PistaDobleEntrada implements Pista {
	private Entrada entrada1;
	private Entrada entrada2;
	
	public PistaDobleEntrada(Vector posicion1, Vector posicion2, double ancho, double tolerancia){
		entrada1 = new EntradaConDireccion(posicion1, ancho, posicion2.restarOtroVector(posicion1), tolerancia);
		entrada2 = new EntradaConDireccion(posicion2, ancho, posicion1.restarOtroVector(posicion2), tolerancia);
	}

	public boolean calcularAterrizaje(Avion avion) {
		
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		
		if ((entrada1.direccionCorrecta(direccionAvion) && entrada1.puntoPertenceALaEntrada(posicionAvion)) == true) return true;
		else if ((entrada2.direccionCorrecta(direccionAvion) && entrada2.puntoPertenceALaEntrada(posicionAvion)) == true) return true;
		
		return false;
	}
	
	
}
