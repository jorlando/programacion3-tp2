package fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.swing.ImageIcon;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Imagen implements ObjetoDibujable {

    protected Image imagen;
    protected ObjetoPosicionable posicionable;

    public Imagen(String imagenUrl, ObjetoPosicionable posicionable) throws IOException {
    	this.posicionable = posicionable;
    	imagen = new ImageIcon(imagenUrl).getImage();
		//this.imagen = ImageIO.read(imagenUrl);
    }
    
	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel)superficieDeDibujo).getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(),null);
	}
	
	public ObjetoPosicionable getPosicionable() {
		return posicionable;
	}
	
}