package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;
import Pistas.Pista;

public class Avion
{
	private Vector posicion;
	private Trayectoria trayectoriaDeVuelo; 
	private EstrategiaAvion tipoDeAvion;
	private double velocidad;
	private double tamaño;
	
	public Avion(Vector PosicionInicial, Trayectoria trayectoriaInicial, double tamaño, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = trayectoriaInicial;
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
		this.tamaño = tamaño;
	}
	
	public Avion(Vector PosicionInicial, Vector DireccionInicial, double tamaño, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = new Trayectoria(DireccionInicial);
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
		this.tamaño = tamaño;
	}
	
	public Vector obtenerDireccion()
	{	
		return this.trayectoriaDeVuelo.Direccion(this.posicion); 
	}

	public Vector obtenerPosicion()
	{
		return this.posicion;
	}
	
	protected void ModificarPosicion(Vector posicion)
	{
		this.posicion = posicion;
	}
	
	public void Avanzar()
	{
		this.posicion = tipoDeAvion.Avanzar(this.posicion, this.velocidad, this.trayectoriaDeVuelo);
	}
	
	public EstrategiaAvion obtenerEstrategia(){
		return this.tipoDeAvion;
	}
	
	public boolean puedoAterrizarEn(Pista unaPista){
		return (unaPista.calcularAterrizaje(this) && tipoDeAvion.puedeAterrizarEn(unaPista));
	}
	
	public boolean colisionaCon(Avion otroAvion){
		return ((((this.posicion.restarOtroVector(otroAvion.posicion)).norma())-(this.tamaño+otroAvion.tamaño)<0) && 
				tipoDeAvion.calcularChoqueCon(otroAvion));
	}
}
