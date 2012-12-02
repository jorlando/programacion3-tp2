package vista.Ventanas.Menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JButton nuevoJuego, continuarJuego, salir;
	
	public PanelMenu(ActionListener oyente){
		
		this.setBackground(Color.white);
		
		FlowLayout layout = new FlowLayout();
		layout.setHgap(20);
		layout.setVgap(20);
		layout.setAlignment(FlowLayout.CENTER);
		
		setLayout(layout);
		
		nuevoJuego = new JButton ("NUEVO JUEGO");
		continuarJuego = new JButton("CONTINUAR JUEGO");
		salir = new JButton("SALIR");
		
		nuevoJuego.addActionListener(oyente);
		continuarJuego.addActionListener(oyente);
		salir.addActionListener(oyente);
		
		nuevoJuego.setActionCommand("nuevoJuego");
		continuarJuego.setActionCommand("continuarJuego");
		salir.setActionCommand("salir");
		
		add(nuevoJuego);
		add(continuarJuego);
		add(salir);
		
	}

}
