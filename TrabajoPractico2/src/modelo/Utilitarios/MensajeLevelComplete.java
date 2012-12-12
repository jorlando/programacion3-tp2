package modelo.Utilitarios;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class MensajeLevelComplete implements ObjetoPosicionable {
	private int miX;
	private int miY;
	public MensajeLevelComplete()
	{
		miX=150;
		miY=100;
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
