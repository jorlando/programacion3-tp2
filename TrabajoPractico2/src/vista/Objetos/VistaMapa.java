package vista.Objetos;

import java.awt.Color;

import modelo.Mapa.Mapa;
import fiuba.algo3.titiritero.dibujables.Cuadrado;

public class VistaMapa extends Cuadrado {

	public VistaMapa(Mapa unMapa){
		super(unMapa.getAncho(), unMapa.getLargo(), unMapa);
		this.setColor(Color.blue);
		
	}
	
}
