package vista.Objetos;

import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MapaVista extends Imagen {
	
	public MapaVista (){
		this.setNombreArchivoImagen("recursos/imagenes/Mapa1.png");
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo){
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
		/*
		 * aca hay que llamar al metodo dibujar de las pistas y de los aviones,
		 * hay que asegurarse de que cada una tenga un posicionable asignado.
		 * 
		 * */
	}
}
