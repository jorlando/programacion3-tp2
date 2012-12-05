package vista.Ventanas.Menu;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelNombre extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JTextField nombre;
	
	public PanelNombre(){
		
		//this.setBackground(Color.white);
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		layout.setVgap(50);
		
		nombre = new JTextField(20);
		
		add(new JLabel("Nombre: "));
		add(nombre);

	}
	
	public String getNombre(){
		return this.nombre.getText();
	}

}
