package vista.Ventanas.Menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelMenu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea texto;
	JButton nuevoJuego, continuarJuego, salir;
	
	public PanelMenu(ActionListener oyente){
		
		this.setBackground(Color.black);
		setOpaque(true);
		setLayout(new FlowLayout());
		
		texto = new JTextArea("");
		texto.setForeground(Color.blue);
		texto.setFont(new Font("Arial", Font.BOLD, 20));
		
		nuevoJuego = new JButton ("NUEVO JUEGO");
		nuevoJuego.addActionListener(oyente);
		nuevoJuego.setActionCommand("nuevoJuego");
		add(nuevoJuego);
				
		if (new File("guardado.xml").exists()){
			continuarJuego = new JButton("REANUDAR JUEGO");
			continuarJuego.addActionListener(oyente);
			continuarJuego.setActionCommand("continuarJuego");
			add(continuarJuego);
		}
		
		salir = new JButton("SALIR");
		salir.addActionListener(oyente);
		salir.setActionCommand("salir");
		add(salir);
		add(texto);		
	}
	
	public void setTexto(String textoAEscribir){
		this.texto.setText(textoAEscribir);
	}

}