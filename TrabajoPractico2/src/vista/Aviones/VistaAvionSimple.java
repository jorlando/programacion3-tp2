package vista.Aviones;

import modelo.Aviones.Avion;
import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaAvionSimple extends Circulo {

	public VistaAvionSimple(Avion unAvion) {
		super(unAvion.getTamaño(), unAvion);
		// TODO Auto-generated constructor stub
	}

}
