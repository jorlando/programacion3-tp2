package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Pistas.PistaSimpleEntrada;

public class PistaPesadaSimple extends PistaSimpleEntrada{
	
	public PistaPesadaSimple(Vector posicion, Vector direccion, double ancho, double tolerancia){
		super(posicion, direccion, ancho, tolerancia);
	}
	
	public boolean puedeAterrizarAvionPesado(){
		return true;	
	}

}
