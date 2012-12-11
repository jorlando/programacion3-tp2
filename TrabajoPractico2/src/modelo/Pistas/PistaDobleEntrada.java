package modelo.Pistas;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import modelo.Utilitarios.Vector;
import modelo.Aviones.Avion;
import modelo.Entradas.Entrada;
import modelo.Entradas.EntradaConDireccion;


public class PistaDobleEntrada extends Pista {
	private Entrada entrada1;
	private Entrada entrada2;
	private ArrayList<Entrada> misEntradas;
	
	public PistaDobleEntrada(Vector posicion1, Vector posicion2, double ancho, double tolerancia){
		Vector direccion = posicion2.restarOtroVector(posicion1);
		Vector direccion2 = posicion1.restarOtroVector(posicion2);
		entrada1 = new EntradaConDireccion(posicion1, ancho, direccion , tolerancia);
		entrada2 = new EntradaConDireccion(posicion2, ancho, direccion2, tolerancia);
		misEntradas = new ArrayList<Entrada>();
		misEntradas.add(entrada1);
		misEntradas.add(entrada2);
	}

	public boolean calcularAterrizaje(Avion avion) {
		
		Vector posicionAvion = avion.obtenerPosicion();
		Vector direccionAvion = avion.obtenerDireccion();
		return (((entrada1.direccionCorrecta(direccionAvion) && entrada1.puntoPertenceALaEntrada(posicionAvion,avion.getVelocidad()))) ||
			((entrada2.direccionCorrecta(direccionAvion) && entrada2.puntoPertenceALaEntrada(posicionAvion,avion.getVelocidad()))));
	}
	
	public int getX(){
		return entrada1.getX();
	}
	
	public int getY(){
		return entrada1.getY()-20;
	}
	
	public Hashtable<String,Object> obtenerPosicionDireccion()
	{
		Random generator = new Random();
		int valorRandom = generator.nextInt(this.misEntradas.size());
		Entrada unaEntrada = this.misEntradas.get(valorRandom);
		
		Hashtable<String,Object> miHash = new Hashtable<String,Object>();
		miHash.put("posicion", unaEntrada.obtenerPosicion());
		miHash.put("direccion", unaEntrada.obtenerDireccion());
		miHash.put("ancho",unaEntrada.obtenerAncho());

		return miHash;
	}
	
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	public boolean puedeAterrizarAvionComputarizado(){
		return true;
	}
}
