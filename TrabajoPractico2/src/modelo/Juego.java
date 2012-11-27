package modelo;

import vista.Ventanas.VentanaPrincipal;
import vista.Ventanas.VentanaJuego;
import modelo.Jugador;
import ar.uba.fi.algo3.titiritero.ControladorJuego;


public class Juego {
	
	private ControladorJuego controlador;
	private Jugador jugador;
	private VentanaPrincipal ventanaPrincipal;
	private VentanaJuego ventanaJuego;
	
    public Juego() {
        jugador = null;
        ventanaPrincipal = null;
        ventanaPrincipal =null;
        controlador = null;
    }
	
	public void comenzarAplicacion(){
	      ventanaPrincipal= new VentanaPrincipal();
	      ventanaPrincipal.pantallaUno();
	      ventanaPrincipal.setVisible(true);
	      //this.juegoNuevo();
	}
}
