package vista.Aviones;

import java.awt.Color;

import modelo.Aviones.Avion;
import fiuba.algo3.titiritero.dibujables.Circulo;

public class VistaAvionPesado extends Circulo {

	public VistaAvionPesado(Avion unAvion) {
		super(unAvion.getTamaño(), unAvion);
		this.setColor(Color.black);
	}

}
