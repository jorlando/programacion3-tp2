package vista.Objetos;

import java.awt.Color;
import java.io.IOException;

import modelo.Mapa.Mapa;
import fiuba.algo3.titiritero.dibujables.*;

public class VistaMapa extends Cuadrado {

	public VistaMapa(Mapa unMapa) throws IOException{
		super(unMapa.getAncho(), unMapa.getLargo(), unMapa);
		this.setColor(Color.blue);
		
	}
	
}
