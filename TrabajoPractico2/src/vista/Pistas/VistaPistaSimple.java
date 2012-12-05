package vista.Pistas;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaPistaSimple extends Imagen {
	
	private static int ancho = 50;
	private Image imagen = new ImageIcon("recursos/imagenes/pistaSimple2.png").getImage();

	public VistaPistaSimple(ObjetoPosicionable objetoPosicionable) throws IOException {
		
		super("recursos/imagenes/pistaSimple2.png", objetoPosicionable);
	}

}
