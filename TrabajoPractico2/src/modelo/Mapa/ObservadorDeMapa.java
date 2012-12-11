package modelo.Mapa;

import java.io.IOException;

import modelo.Utilitarios.*;
import vista.Ventanas.*;

import fiuba.algo3.titiritero.modelo.ObservadorDeGameLoop;

public class ObservadorDeMapa implements ObservadorDeGameLoop {
	
	private Mapa mapa;
	private VistaMensajeAterrizado mensajeGood;
	private VistaMensajeLevelComplete mensajeLevelComplete;
	
	public ObservadorDeMapa(Mapa unMapa){
		this.mapa= unMapa;
		this.mensajeGood=this.crearMensajeGood();
		this.mensajeLevelComplete=this.crearMensajeLevelComplete();
	}

	public VistaMensajeAterrizado crearMensajeGood(){
		MensajeAterrizado unAterrizaje = new MensajeAterrizado();
		VistaMensajeAterrizado vistaAMostrar=null;
		try {
			vistaAMostrar= new VistaMensajeAterrizado(unAterrizaje);
		} catch (IOException e) {}
		return vistaAMostrar;
	}
	
	public VistaMensajeLevelComplete crearMensajeLevelComplete(){
		MensajeLevelComplete unAterrizaje = new MensajeLevelComplete();
		VistaMensajeLevelComplete vistaAMostrar=null;
		try {
			vistaAMostrar= new VistaMensajeLevelComplete(unAterrizaje);
		} catch (IOException e) {}
		return vistaAMostrar;
	}
	
	
	
	@Override
	public void notificarCicloFinalizado() {
		if (mapa.estaVisibleMensaje(this.mensajeGood)) mapa.ocultarMensaje(this.mensajeGood);
		if (mapa.estaVisibleMensaje(this.mensajeLevelComplete)) mapa.ocultarMensaje(this.mensajeLevelComplete);
		
		try {mapa.agregarAviones();} catch (IOException e) {}
		if (mapa.aterrizarAviones()) mapa.mostrarMensaje(this.mensajeGood);
		if(mapa.cambioElNivel()) mapa.mostrarMensaje(this.mensajeLevelComplete);
		mapa.borrarAvionesQueSeFueronDelMapa();
	}

}
