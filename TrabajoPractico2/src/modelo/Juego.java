package modelo;

import vista.Ventanas.VentanaPrincipal;
import vista.Ventanas.VentanaJuego;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

import modelo.Jugador;
import modelo.Mapa.Mapa;




public class Juego {
	
	private ControladorJuego controlador;
	private Jugador jugador;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaJuego ventanaJuego;
	
    public Juego() {
        jugador = null;
        ventanaPrincipal = null;
        ventanaPrincipal = null;
        controlador = new ControladorJuego (true);
    }
	
	public void comenzarAplicacion(){
	      ventanaPrincipal= new VentanaPrincipal(controlador);
	      ventanaPrincipal.pantallaMenu();
	      ventanaPrincipal.setVisible(true);
	      if (ventanaPrincipal.getSeleccion() == 1){
	    	  this.juegoNuevo();
	      }
	      else if(ventanaPrincipal.getSeleccion() == 2){
	    	  this.juegoGrabado();
	      }
	}
	
	public void juegoNuevo(){
		//empezamos un juego de 0
		Mapa mapa = new Mapa(800,600); //hay que ver bien lo del tamaño del mapa 
		jugador = new Jugador();
		mapa.setJugador(jugador);
		
		
	}
	
	public void juegoGrabado(){
		//necesitariamos saber persistencia jaja
	}
}
