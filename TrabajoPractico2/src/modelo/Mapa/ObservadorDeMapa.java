package modelo.Mapa;

import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorDeMapa implements ObservadorDeGameLoop {
	
	private Mapa mapa;
	
	public ObservadorDeMapa(Mapa unMapa){
		this.mapa= unMapa;
	}
	

	@Override
	public void notificarCicloFinalizado() {
		mapa.agregarAviones();
	}

}
