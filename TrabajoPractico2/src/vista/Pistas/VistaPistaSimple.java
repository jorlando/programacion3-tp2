package vista.Pistas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPistaSimple extends Imagen {

	public VistaPistaSimple(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/pistaSimple2.png", objetoPosicionable);
	}

}
