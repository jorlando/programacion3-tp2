package vista.Aviones;

import java.awt.Color;

import modelo.Aviones.Avion;
import fiuba.algo3.titiritero.dibujables.Circulo;

public class VistaAvionHelicoptero extends Circulo {

	public VistaAvionHelicoptero(Avion unAvion) {
		super(unAvion.getTamaño(), unAvion);
		this.setColor(Color.red);
	}

}