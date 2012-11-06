package Utilitarios;

public class Vector {
	private double x; //los manejo con double por la sqrt
	private double y;
	
	public Vector (double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public boolean esIgualA(Vector otro){
		return ((this.x==otro.x) && (this.y == otro.y));
	}
	
	public double norma(){
		return Math.sqrt((x*x)+(y*y));
	}
	
	public Vector normalizar(){
		return new Vector(x/this.norma(),y/this.norma());
	}
	
	public Vector multiplicarPorEscalar(double e){//ya que estamos hacemos todo con double para no perder coherencia
		return (new Vector(x*e,y*e));
	}
	
	public Vector sumarOtroVector(Vector otro){
		return new Vector(this.x+otro.x,this.y+otro.y);
	}
	
	public Vector restarOtroVector(Vector otro){
		return new Vector(this.x-otro.x,this.y-otro.y);
	}
	
	public Vector obtenerPerpendicular(){
		return new Vector(-(this.y), this.x );
	}
	
	public double pendiente(){
		return y/x;
	}

}
