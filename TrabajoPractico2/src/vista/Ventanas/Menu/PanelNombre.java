package vista.Ventanas.Menu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelNombre extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JTextField nombre;
	
	public PanelNombre(){
		
		FlowLayout layout = new FlowLayout();
		setLayout(layout);
		layout.setVgap(50);
		//this.setSize(400,280);
		//nombre = new JTextField(20);
		
		//add(new JLabel("Nombre: "));
		//add(nombre);


	}
	
	public String getNombre(){
		return this.nombre.getText();
	}

	public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon("recursos/imagenes/insertcoin.png");        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        setOpaque(false);
        super.paintComponent(g);
    }

}
