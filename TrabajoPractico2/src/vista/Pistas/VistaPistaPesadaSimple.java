package vista.Pistas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPistaPesadaSimple extends Imagen{

	public VistaPistaPesadaSimple(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/pistaLarga.png", objetoPosicionable);
	}
}
