package modelo.Utilitarios;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;


public class MensajeGameOver implements ObjetoPosicionable{
	private int miX;
	private int miY;
	public MensajeGameOver()
	{
		miX=80;
		miY=0;
	}
	@Override
	public int getX(){
		return this.miX;
	}
	
	@Override
	public int getY(){
		return this.miY;
	}
}
