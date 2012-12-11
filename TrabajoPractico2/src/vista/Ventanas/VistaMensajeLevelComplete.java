package vista.Ventanas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaMensajeLevelComplete extends Imagen{
	
	public VistaMensajeLevelComplete(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/levelComplete.png", objetoPosicionable);
	}


}
