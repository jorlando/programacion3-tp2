package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Pistas.PistaSimpleEntrada;

public class PistaPesadaSimple extends PistaSimpleEntrada{
	
	public PistaPesadaSimple(Vector posicion, Vector direccion, double ancho, double tolerancia){
		super(posicion, direccion, ancho, tolerancia);
	}
	
	public boolean puedeAterrizarAvionSimple(){
		System.out.println("PISTA PESADA AVION SIMPLE");
		return true;
	}
	
	public boolean puedeAterrizarAvionPesado(){
		System.out.println("PISTA PESADA AVION PESADO");
		return true;
	}
	
	public boolean puedeAterrizarAvionComputarizado(){
		System.out.println("PISTA PESADA AVION COMPUTARIZADO");
		return true;
	}

}
