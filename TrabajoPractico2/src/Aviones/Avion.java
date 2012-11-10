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
	private double tama�o;
	
	public Avion(Vector PosicionInicial, Trayectoria trayectoriaInicial, double tama�o, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = trayectoriaInicial;
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
		this.tama�o = tama�o;
	}
	
	public Avion(Vector PosicionInicial, Vector DireccionInicial, double tama�o, EstrategiaAvion tipoDeAvion)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = new Trayectoria(DireccionInicial);
		this.tipoDeAvion = tipoDeAvion;
		this.velocidad = 1;
		this.tama�o = tama�o;
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
		return ((((this.posicion.restarOtroVector(otroAvion.posicion)).norma())-(this.tama�o+otroAvion.tama�o)<0) && 
				tipoDeAvion.calcularChoqueCon(otroAvion));
	}
}
