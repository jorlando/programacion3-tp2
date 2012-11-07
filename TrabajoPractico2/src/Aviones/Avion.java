package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;

public abstract class Avion
{
	private Vector posicion;
	private Trayectoria trayectoriaDeVuelo; 
	
	Avion(Vector PosicionInicial, Trayectoria trayectoriaInicial)
	{
		this.posicion = PosicionInicial;
		this.trayectoriaDeVuelo = trayectoriaInicial;
	}

	public Vector obtenerDireccion()
	{	
		return this.trayectoriaDeVuelo.Direccion(); 
	}

	public Vector obtenerPosicion()
	{
		return this.posicion;
	}

}
