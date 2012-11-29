package modelo.Pistas;

import java.util.Iterator;
import java.util.ArrayList;
import modelo.Aviones.Avion;

public abstract class Pista{
	
	public abstract boolean calcularAterrizaje(Avion unAvion);
	
	public ArrayList<Avion> aterrizarAviones (ArrayList<Avion> avionesAterrizar)
	{
		ArrayList<Avion> avionesAterrizados = new ArrayList<Avion>();
		Iterator<Avion> iteradorAvion = avionesAterrizar.iterator();
		while (iteradorAvion.hasNext())
		{
			Avion avionAEvaluar= iteradorAvion.next();
			if(this.calcularAterrizaje(avionAEvaluar)) avionesAterrizados.add(avionAEvaluar);
		}
		return avionesAterrizados;

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
