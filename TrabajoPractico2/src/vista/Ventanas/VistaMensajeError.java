package vista.Ventanas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaMensajeError extends Imagen{

	public VistaMensajeError(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/gameOver.png", objetoPosicionable);
	}
}
