package Pistas;

import java.util.Iterator;
import java.util.ArrayList;
import Aviones.Avion;


public abstract class Pista {
	
	protected abstract boolean calcularAterrizaje(Avion unAvion);
	
	public void aterrizarAviones (ArrayList<Avion> avionesAterrizar)
	{
		Iterator<Avion> iteradorAvion = avionesAterrizar.iterator();
		while (iteradorAvion.hasNext())
		{
			Avion avionAEvaluar= iteradorAvion.next();
			if(this.calcularAterrizaje(avionAEvaluar)) avionesAterrizar.remove(avionAEvaluar);
		}
	}
	
	public boolean puedeAterrizarHelicoptero(){
		return false;
	}
	
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	public boolean puedeAterrizarAvionPesado(){
		return false;
	}

}
