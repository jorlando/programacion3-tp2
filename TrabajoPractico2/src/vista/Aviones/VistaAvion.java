package vista.Aviones;

import java.awt.Graphics;
import java.io.IOException;

import modelo.Aviones.Avion;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VistaAvion extends Imagen {

	public VistaAvion(Avion unAvion) throws IOException {
		super(unAvion.miImagen(), unAvion);
		unAvion.guardarMiVista(this);
	}
	
	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX()-(this.imagen.getWidth(null)/2), this.posicionable.getY()-(this.imagen.getHeight(null)/2),null);
	}

}
