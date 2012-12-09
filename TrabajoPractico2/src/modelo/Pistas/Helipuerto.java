package modelo.Pistas;

import java.util.ArrayList;
import java.util.Hashtable;

import modelo.Utilitarios.Vector;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaSinDireccion;

public class Helipuerto extends Pista {
	private Entrada entrada;
	
	public Helipuerto (Vector posicion, double ancho){
		entrada = new EntradaSinDireccion(posicion,ancho);
	}
	
	public boolean calcularAterrizaje(Avion avion){
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (entrada.puntoPertenceALaEntrada(posicionAvion, avion.getVelocidad()) && entrada.direccionCorrecta(direccionAvion));
	}
	
	public boolean puedeAterrizarHelicoptero(){
		return true;
	}
	
	public int getX(){
		return entrada.getX();
	}
	
	public int getY(){
		return entrada.getY();
	}
	
	public boolean tieneDireccion()
	{
		return false;
	}
	
	public Hashtable obtenerPosicionDireccion()
	{
		Hashtable miHash = new Hashtable();
		miHash.put("posicion", this.entrada.obtenerPosicion());
		miHash.put("direccion", this.entrada.obtenerDireccion());
		miHash.put("ancho", 0);
		return miHash;
	}
	
}
