package vista.Aviones;

import java.awt.Color;
import java.io.IOException;

import modelo.Aviones.Avion;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.dibujables.Imagen;

public class VistaAvion extends Imagen {

	public VistaAvion(Avion unAvion) throws IOException {
		super(unAvion.miImagen(), unAvion);
	}

}
