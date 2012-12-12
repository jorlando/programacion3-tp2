package vista.Ventanas.Menu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelInfo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JTextArea texto;

	public PanelInfo (){
		
		this.setBackground(Color.black);
		texto = new JTextArea("Bienvenido a Cop Control");
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		layout.setVgap(0);
		setLayout(layout);
		setOpaque(true);
		texto.setForeground(Color.blue);
		texto.setFont(new Font("Arial", Font.BOLD, 40));
		
		add(texto);
		
	}
	
	public void setTexto(String textoAEscribir){
		this.texto.setText(textoAEscribir);
	}
	
}
