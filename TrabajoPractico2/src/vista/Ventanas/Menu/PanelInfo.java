package vista.Ventanas.Menu;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	JLabel texto;

	public PanelInfo (){
		this.setBackground(Color.white);
		
		texto = new JLabel("Bienvenido a Cop Control");
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		layout.setVgap(20);
		setLayout(layout);
		
		add(texto);
		
	}
	
	public void setTexto(String textoAEscribir){
		this.texto.setText(textoAEscribir);
	}

}
