package modelo.Pistas;

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
	
	@Override
	public boolean calcularAterrizaje(Avion avion){
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (entrada.puntoPertenceALaEntrada(posicionAvion, avion.getVelocidad()) && entrada.direccionCorrecta(direccionAvion));
	}
	
	@Override
	public boolean puedeAterrizarHelicoptero(){
		return true;
	}	
	//se resta 55 para que el punto de aterrizaje sea en el centro de la imagen
	@Override
	public int getX(){
		return entrada.getX()-55;
	}
	
	@Override
	public int getY(){
		return entrada.getY()-55;
	}
	
	@Override
	public boolean tieneDireccion()
	{
		return false;
	}
	
	@Override
	public Hashtable<String,Object> obtenerPosicionDireccion()
	{
		Hashtable<String,Object> miHash = new Hashtable<String,Object>();
		miHash.put("posicion", this.entrada.obtenerPosicion());
		miHash.put("direccion", this.entrada.obtenerDireccion());
		miHash.put("ancho", 0);
		return miHash;
	}
	
}
