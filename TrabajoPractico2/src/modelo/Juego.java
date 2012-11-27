package modelo;

import vista.Ventanas.VentanaPrincipal;
import vista.Ventanas.VentanaJuego;
import vista.Objetos.MapaVista;
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
	    	  ventanaPrincipal.setVisible(false);
	    	  this.juegoNuevo();
	      }
	      else if(ventanaPrincipal.getSeleccion() == 2){
	    	  this.juegoGrabado();
	      }
	}
	
	public void juegoNuevo(){
		//empezamos un juego de 0
		ventanaJuego = new VentanaJuego(controlador);
		Mapa mapa = new Mapa(); //hay que ver bien lo del tamaño del mapa 
		jugador = new Jugador();
		mapa.setJugador(jugador);
		
		/*Vistas*/
		controlador.setSuperficieDeDibujo(ventanaJuego);
		ventanaJuego.setVisible(true);
		
		MapaVista mapaVista = new MapaVista();
		mapaVista.setPosicionable(mapa);
		
		/*Objetos Vivos*/
		controlador.agregarObjetoVivo(mapa);
		
		/*Agregamos Dibujables*/
		controlador.agregarDibujable(mapaVista);
		
		controlador.setIntervaloSimulacion(200);
		controlador.comenzarJuego();
	}
	
	public void juegoGrabado(){
		//necesitariamos saber persistencia jaja
	}
}
