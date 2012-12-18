package modelo.Entradas;

import modelo.Utilitarios.Vector;


public class EntradaConDireccion extends Entrada {
	
	private Vector direccionEntrada;
	private double tolerancia; //grados.
		
	public EntradaConDireccion(Vector posicion, double ancho, Vector direccion, double tol){
		this.posicion = posicion;
		this.ancho=ancho;
		direccionEntrada= direccion;
		tolerancia = tol;
	}
	
	
	public boolean puntoPertenceALaEntrada(Vector vector, double velocidadAvion){
		Vector v1 = posicion;
		Vector v3= direccionEntrada.obtenerPerpendicular().multiplicarPorEscalar(ancho);
		Vector v2 = posicion.sumarOtroVector(v3);
		if (v1.getX() == v2.getX()){
			return (vector.restarOtroVector(posicion).norma() <= ancho) && ( vector.getX() > (v1.getX() - velocidadAvion) && vector.getX() < (v1.getX() + velocidadAvion));
		}
				
		double minimo=Math.min(v1.getX(),v2.getX());
		double maximo=Math.max(v1.getY(),v2.getY());
		return (vector.restarOtroVector(posicion).norma() <= ancho) && ((minimo <= vector.getX()) && (vector.getY() <= maximo)); //hay que revisar que esto ande
	}
	
	@Override
	public boolean direccionCorrecta(Vector direccion){
		return (tolerancia >= Math.abs(Math.toDegrees(direccion.anguloFormadoCon(direccionEntrada))));
	}
	@Override
	public Vector obtenerDireccion(){
		return this.direccionEntrada;
	}
}
