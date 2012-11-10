package Pistas;

import Utilitarios.Vector;

public class PistaPesadaSimple extends PistaSimpleEntrada{
	
	public PistaPesadaSimple(Vector posicion, Vector direccion, double ancho, double tolerancia){
		super(posicion, direccion, ancho, tolerancia);
	}
	
	public boolean puedeAterrizarAvionPesado(){
		return true;	
	}

}
