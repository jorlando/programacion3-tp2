package modelo.Pistas;

import java.util.Hashtable;

import modelo.Utilitarios.Vector;
import modelo.Pistas.Pista;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaConDireccion;


public class PistaSimpleEntrada extends Pista {
	protected Entrada entrada;
	
	public PistaSimpleEntrada(Vector posicion, Vector direccion, double ancho, double tolerancia){
		entrada = new EntradaConDireccion(posicion,ancho,direccion,tolerancia);
	}
	
	@Override
	public boolean calcularAterrizaje(Avion avion) {
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (entrada.puntoPertenceALaEntrada(posicionAvion,avion.getVelocidad()) && entrada.direccionCorrecta(direccionAvion));
	}
	
	@Override
	public int getX(){
		return this.entrada.getX();
	}
	
	@Override
	public int getY(){
		return this.entrada.getY();
	}
	
	@Override
	public Hashtable<String,Object> obtenerPosicionDireccion()
	{
		Hashtable<String,Object> miHash = new Hashtable<String,Object>();
		miHash.put("posicion", this.entrada.obtenerPosicion());
		miHash.put("direccion", this.entrada.obtenerDireccion());
		miHash.put("ancho", this.entrada.obtenerAncho());

		return miHash;
	}
	
	@Override
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	@Override
	public boolean puedeAterrizarAvionComputarizado(){
		return true;
	}
	
}
