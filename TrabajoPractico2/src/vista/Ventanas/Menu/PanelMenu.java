package vista.Ventanas.Menu;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea texto;
	JButton nuevoJuego, continuarJuego, salir;
	
	public PanelMenu(ActionListener oyente){
		
		//this.setBackground(Color.white);
		
		setLayout(new FlowLayout());
		
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
	
	public void setTexto(String textoAEscribir){
		this.texto.setText(textoAEscribir);
	}

}