package vista;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana{
	
	public VentanaPrincipal(int ancho, int alto, ControladorJuego unControlador) {
        super(ancho,alto,unControlador);
        this.setTitle("Cop-Control");
	}
	
	private static final long serialVersionUID = 1L;
}
