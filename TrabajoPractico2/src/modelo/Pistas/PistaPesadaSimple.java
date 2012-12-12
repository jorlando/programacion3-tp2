package modelo.Pistas;

import modelo.Utilitarios.Vector;
import modelo.Entradas.EntradaConDireccion;
import modelo.Pistas.PistaSimpleEntrada;

public class PistaPesadaSimple extends PistaSimpleEntrada{
	
	public PistaPesadaSimple(Vector posicion, Vector direccion, double ancho, double tolerancia){
		super(posicion, direccion, ancho, tolerancia);
		entrada = new EntradaConDireccion(posicion,ancho,direccion,tolerancia);
	}
	
	@Override
	public boolean puedeAterrizarAvionSimple(){
		return true;
	}
	
	@Override
	public boolean puedeAterrizarAvionPesado(){
		return true;
	}
	
	@Override
	public boolean puedeAterrizarAvionComputarizado(){
		return true;
	}
	
	

}
