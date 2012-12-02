package vista.Ventanas.Menu;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenu extends JMenuBar {

	JMenu menu, ayudaMenu;
	JMenuItem nuevoJuego,continuarJuego,salir,ayuda,acerca;
	
	private static final long serialVersionUID = 1L;
	
	public BarraMenu(ActionListener oyente){
		
	menu = new JMenu("MENU");
	ayudaMenu = new JMenu("AYUDA"); 
	nuevoJuego = new JMenuItem("NUEVO JUEGO");
	continuarJuego = new JMenuItem("CONTINUAR JUEGO");
	salir = new JMenuItem("SALIR");
	ayuda = new JMenuItem("AYUDA");
	acerca = new JMenuItem("ACERCA");
	
	nuevoJuego.addActionListener(oyente);
	continuarJuego.addActionListener(oyente);
	salir.addActionListener(oyente);
	ayuda.addActionListener(oyente);
	acerca.addActionListener(oyente);
	
	nuevoJuego.setActionCommand("nuevoJuego");
	continuarJuego.setActionCommand("continuarJuego");
	salir.setActionCommand("salir");
	ayuda.setActionCommand("ayuda");
	acerca.setActionCommand("acerca");
	
	
	menu.add(nuevoJuego);
	menu.add(continuarJuego);
	menu.addSeparator();
	menu.add(salir);
	ayudaMenu.add(ayuda);
	ayudaMenu.add(acerca);
	
	this.add(menu);
	this.add(ayudaMenu);
	
	
	}

}
