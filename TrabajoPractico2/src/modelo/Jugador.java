package modelo;

public class Jugador {
	
	private int puntaje; //aviones aterrizados (o algo que se quiera agregar)
	private String nombre; //para mantener algun registro de los puntajes mas altos y esas cosas
	
	public Jugador(){
		puntaje = 0;
		nombre = "";
	}
	
	public Jugador(String nombre, int puntos){
		this.puntaje = puntos;
		this.nombre = nombre;
	}
	
	public void sumarPuntaje(int puntos){
		this.puntaje += puntos;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre; 
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
