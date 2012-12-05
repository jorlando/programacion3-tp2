package vista.Pistas;

import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaHelipuerto extends Imagen{

	public VistaHelipuerto(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/helipuerto.png", objetoPosicionable);
	}
}