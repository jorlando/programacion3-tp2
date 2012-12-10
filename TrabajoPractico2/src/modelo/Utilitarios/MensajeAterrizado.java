package modelo.Utilitarios;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class MensajeAterrizado implements ObjetoPosicionable {
	private int miX;
	private int miY;
	public MensajeAterrizado()
	{
		miX=150;
		miY=150;
	}
	public int getX(){
		return this.miX;
	}
	
	public int getY(){
		return this.miY;
	}
}
