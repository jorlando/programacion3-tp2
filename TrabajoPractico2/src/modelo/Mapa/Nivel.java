package modelo.Mapa;

import modelo.Aviones.*;
import modelo.Utilitarios.Vector;

public class Nivel {
	
	private int nivel;
	private int intervaloTiempo;
	private int velocidadAviones;
	
	public Nivel(){
		this.nivel = 1;
		this.intervaloTiempo = 1; //hay que ver como manejamos esto
		this.velocidadAviones = 1; //es por lo que se multiplica la velocidad estandar de los aviones
	}
	
	public Avion nuevoAvion(){
		//Habria que hacer una funcion para calcular estas cosas
		Vector posicion = calcularNuevaPosicion();
		Vector direccion = calcularNuevaDireccion();
		EstrategiaAvion estrategia = new EstrategiaAvionSimple();
		double tamaño = 4;
		
		return new Avion(posicion,direccion,tamaño,estrategia);
	}
	
	private Vector calcularNuevaPosicion(){
		return new Vector(0,0);
	}
	
	private Vector calcularNuevaDireccion(){
		return new Vector(1,0);
	}

}
