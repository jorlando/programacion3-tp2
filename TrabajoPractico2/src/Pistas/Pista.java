package Pistas;

import Aviones.Avion;


public abstract class Pista {
	
	public abstract boolean calcularAterrizaje(Avion unAvion);
	
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
