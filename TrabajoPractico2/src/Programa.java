import vista.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ControladorJuego controlador = new ControladorJuego(true);
		Ventana ventana = new VentanaPrincipal(1024,768,controlador);
		controlador.setSuperficieDeDibujo(ventana);
        ventana.setVisible(true);
        
        controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
	}

}
