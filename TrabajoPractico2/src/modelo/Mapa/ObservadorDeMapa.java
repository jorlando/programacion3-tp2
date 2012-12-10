package modelo.Mapa;

import java.io.IOException;

import modelo.Utilitarios.MensajeAterrizado;
import vista.Ventanas.VistaMensajeAterrizado;

import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorDeMapa implements ObservadorDeGameLoop {
	
	private Mapa mapa;
	private VistaMensajeAterrizado mensajeGood;
	
	public ObservadorDeMapa(Mapa unMapa){
		this.mapa= unMapa;
		this.mensajeGood=this.crearMensajeGood();
	}

	public VistaMensajeAterrizado crearMensajeGood(){
		MensajeAterrizado unAterrizaje = new MensajeAterrizado();
		VistaMensajeAterrizado vistaAMostrar=null;
		try {
			vistaAMostrar= new VistaMensajeAterrizado(unAterrizaje);
		} catch (IOException e) {}
		return vistaAMostrar;
	}
	
	
	@Override
	public void notificarCicloFinalizado() {
		if (mapa.estaVisibleMensaje(this.mensajeGood)) mapa.ocultarMensaje(this.mensajeGood);
		
		try {mapa.agregarAviones();} catch (IOException e) {}
		if (mapa.aterrizarAviones()) mapa.mostrarMensaje(this.mensajeGood);
		mapa.borrarAvionesQueSeFueronDelMapa();
	}

}
