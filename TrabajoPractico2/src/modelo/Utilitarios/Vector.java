package modelo.Utilitarios;


public class Vector {
	private double x;
	private double y;
	
	public Vector (double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Vector (Vector aCopiar)
	{
		this.x = aCopiar.getX();
		this.y = aCopiar.getY();
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
		if (x == 0.0 && y == 0.0) return new Vector(0.0,0.0);
		return new Vector(x/this.norma(),y/this.norma());
	}
	
	public Vector multiplicarPorEscalar(double e){
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
	
	public double productoEscalar(Vector otro){
		
		return ((this.x*otro.x) + (this.y*otro.y));
	}
	
	public double anguloFormadoCon(Vector otro){
		if (this.norma()*otro.norma()==0) return 0;
		return Math.acos((this.productoEscalar(otro))/(this.norma()*otro.norma()));
	}

}
