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
	
	@Override
	public boolean puntoPertenceALaEntrada(Vector vector, double velocidadAvion){
		Vector v1 = posicion;
		Vector v2 = posicion.sumarOtroVector(direccionEntrada.obtenerPerpendicular());
		if (v1.getX() == v2.getX()){ //si son iguales falla (division por 0)
			//System.out.println("pista!");
			return (vector.restarOtroVector(posicion).norma() <= ancho) && ( vector.getX() > (v1.getX() - velocidadAvion) && vector.getX() < (v1.getX() + velocidadAvion));
		}
		double yMin = ((v2.getY()-v1.getY())/(v2.getX()-v1.getX()))*(vector.getX()-v1.getX())+v1.getY();
		// double y = ((v2.getY()-v1.getY())/(v2.getX()-v1.getX()))*(vector.getX()-v1.getX())+v1.getY();
		double yMax = ((v2.getY()-v1.getY())/(v2.getX()-v1.getX()))*(vector.getX()-v1.getX())+v1.getY();
																									//GN Aca se tocan los condicionales
		return (vector.restarOtroVector(posicion).norma() <= ancho) && ((yMin <= vector.getY()) && (vector.getY() <= yMax)); //hay que revisar que esto ande
			
	}
	
	@Override
	public boolean direccionCorrecta(Vector direccion){
		return (tolerancia >= Math.abs(Math.toDegrees(direccion.anguloFormadoCon(direccionEntrada))));
	}
	@Override
	public Vector obtenerDireccion()
	{
		return this.direccionEntrada;
	}

}
