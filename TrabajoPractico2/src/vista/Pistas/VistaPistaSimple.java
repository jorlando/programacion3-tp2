package vista.Pistas;

import java.awt.Graphics;
import java.io.IOException;

import fiuba.algo3.titiritero.dibujables.*;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaPistaSimple extends Imagen {
	
	private static int ancho = 50;

	public VistaPistaSimple(ObjetoPosicionable objetoPosicionable) throws IOException {
		super("recursos/imagenes/pistaSimple2.png", objetoPosicionable);
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY()-(ancho/2),null);
	}

}
