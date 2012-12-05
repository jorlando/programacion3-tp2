package vista.Pistas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPistaDobleEntrada extends Imagen{

	public VistaPistaDobleEntrada(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/pistaDobleEntrada.png", objetoPosicionable);
	}
}
