package modelo.Utilitarios;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;


public class MensajeGameOver implements ObjetoPosicionable{
	private int miX;
	private int miY;
	public MensajeGameOver()
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
