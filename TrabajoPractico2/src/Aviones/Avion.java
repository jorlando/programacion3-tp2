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
	
	public Avion(Vector PosicionInicial, Trayectoria trayectoriaInicial, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = trayectoriaInicial;
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
	}
	
	public Avion(Vector PosicionInicial, Vector DireccionInicial, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = new Trayectoria(DireccionInicial);
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
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

}
