package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Entradas.EntradaConDireccion;
import modelo.Pistas.PistaSimpleEntrada;

public class PistaPesadaSimple extends PistaSimpleEntrada{
	
	public PistaPesadaSimple(Vector posicion, Vector direccion, double ancho, double tolerancia){
		super(posicion, direccion, ancho, tolerancia);
		entrada = new EntradaConDireccion(posicion,ancho,direccion,tolerancia);
	}
	
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	public boolean puedeAterrizarAvionPesado(){
		return true;
	}
	
	public boolean puedeAterrizarAvionComputarizado(){
		return true;
	}
	
	

}
