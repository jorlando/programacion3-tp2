package vista.Objetos;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaWaypoint extends Circulo {

	public VistaWaypoint( ObjetoPosicionable objetoPosicionable) {
		super(2, objetoPosicionable);
		this.setColor(Color.RED);
	}

}
