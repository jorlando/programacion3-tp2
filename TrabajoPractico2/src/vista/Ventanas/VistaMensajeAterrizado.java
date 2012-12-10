package vista.Ventanas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaMensajeAterrizado extends Imagen{
	
	public VistaMensajeAterrizado(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/good.png", objetoPosicionable);
	}

}
