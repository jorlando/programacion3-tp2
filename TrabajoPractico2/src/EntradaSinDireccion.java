import Utilitarios.Vector;


public class EntradaSinDireccion extends Entrada {
	// tienen que estar en la clase madre
	private Vector posicion;
	private double ancho;

	public EntradaSinDireccion(double x, double y, double ancho){
		posicion = new Vector(x,y);
		this.ancho = ancho;
	}
	
	public boolean puntoPertenceALaEntrada(Vector vector) {
		if (vector.restarOtroVector(posicion).norma() < ancho) return true;
		return false;
	}
	
	public boolean direccionCorrecta(Vector direccion){
		return true;
	}

}
