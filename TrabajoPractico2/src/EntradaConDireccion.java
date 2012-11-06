import Utilitarios.Vector;


public class EntradaConDireccion extends Entrada {
	
	private Vector direccionEntrada;
	private Vector posicion;
	private double ancho;
	private double tolerancia; //grados.
		
	public EntradaConDireccion(double x, double y, double ancho, Vector direccion, double tol){
		posicion = new Vector(x,y);
		this.ancho=ancho;
		direccionEntrada= direccion;
		tolerancia = tol;
	}
	
	public boolean puntoPertenceALaEntrada(Vector vector){
		if (vector.restarOtroVector(posicion).norma() < ancho){
			double y = (direccionEntrada.obtenerPerpendicular().pendiente()*(vector.getX()-posicion.getX()))+posicion.getY(); //esto es la formula de la recta que pasa por un punto.
			if (y == vector.getY()){
				return true;
			}
		}
		return false;
	}
	
	public boolean direccionCorrecta(Vector direccion){
		//hay que ver que la tolerancia no sea 90 o algo parecido.
		double tolEnRadianes = Math.toRadians(tolerancia);
		Vector desvio = (direccionEntrada.obtenerPerpendicular().multiplicarPorEscalar(Math.tan(tolEnRadianes)*direccionEntrada.norma()));
		if (direccionEntrada.normalizar().restarOtroVector(direccion.normalizar()).norma()<=desvio.norma()){
			return true;
		}	
		return false;
	}

}
