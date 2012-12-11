package modelo.Pistas;

import java.util.Hashtable;

import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaConDireccion;


public class PistaSimpleEntrada extends Pista {
	private Entrada entrada;
	
	public PistaSimpleEntrada(Vector posicion, Vector direccion, double ancho, double tolerancia){
		entrada = new EntradaConDireccion(posicion,ancho,direccion,tolerancia);
	}
	
	public boolean calcularAterrizaje(Avion avion) {
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		if(entrada.puntoPertenceALaEntrada(posicionAvion,avion.getVelocidad()) && entrada.direccionCorrecta(direccionAvion)){
			System.out.println("aterriza");
		}
		return (entrada.puntoPertenceALaEntrada(posicionAvion,avion.getVelocidad()) && entrada.direccionCorrecta(direccionAvion));
	}
	
	public int getX(){
		return this.entrada.getX();
	}
	
	public int getY(){
		return this.entrada.getY();
	}
	
	public Hashtable<String,Object> obtenerPosicionDireccion()
	{
		Hashtable<String,Object> miHash = new Hashtable<String,Object>();
		miHash.put("posicion", this.entrada.obtenerPosicion());
		miHash.put("direccion", this.entrada.obtenerDireccion());
		miHash.put("ancho", this.entrada.obtenerAncho());

		return miHash;
	}
	
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	public boolean puedeAterrizarAvionComputarizado(){
		return true;
	}
	
}
