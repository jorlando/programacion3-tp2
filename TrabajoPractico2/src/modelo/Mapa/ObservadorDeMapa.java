package modelo.Mapa;

import java.io.IOException;

import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorDeMapa implements ObservadorDeGameLoop {
	
	private Mapa mapa;
	
	public ObservadorDeMapa(Mapa unMapa){
		this.mapa= unMapa;
	}

	@Override
	public void notificarCicloFinalizado() {
		try {
			mapa.agregarAviones();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
