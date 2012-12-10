package modelo.Pistas;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.ArrayList;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import modelo.Aviones.Avion;
import modelo.Utilitarios.Vector;

public abstract class Pista implements ObjetoPosicionable{
	
	public abstract boolean calcularAterrizaje(Avion unAvion);
	
	public ArrayList<Avion> aterrizarAviones (ArrayList<Avion> avionesAterrizar)
	{
		ArrayList<Avion> avionesAterrizados = new ArrayList<Avion>();
		Iterator<Avion> iteradorAvion = avionesAterrizar.iterator();
		while (iteradorAvion.hasNext())
		{
			Avion avionAEvaluar= iteradorAvion.next();
			if(avionAEvaluar.puedoAterrizarEn(this)) {
				avionesAterrizados.add(avionAEvaluar);
				System.out.println("ATERRIZANDO AVION");
			}
		}
		return avionesAterrizados;
	}
	
	public boolean puedeAterrizarHelicoptero(){
		return false;
	}
	
	public boolean puedeAterrizarAvionSimple(){
		return false;
	}
	
	public boolean puedeAterrizarAvionPesado(){
		return false;
	}
	
	public boolean puedeAterrizarAvionComputarizado()
	{
		return false;
	}

	public boolean tieneDireccion()
	{
		return true;
	}
	
	public abstract Hashtable obtenerPosicionDireccion();
	
}
