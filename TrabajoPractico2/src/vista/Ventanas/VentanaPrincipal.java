package vista.Ventanas;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import vista.Ventanas.VentanaJuego;
import vista.Ventanas.Menu.*;

public class VentanaPrincipal extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BarraMenu menuBar;
	PanelMenu panelMenu;
	PanelNombre panelNombre;
	PanelInfo panelInfo;
	ImageIcon fondo;
	
	public VentanaPrincipal(){
		//Inicializamos la ventana
		super ("CopControl");
		setBounds(0,0,640,480);
		setResizable(false);
	}
	
	public void iniciar(){
		
		setVisible(true);
		//Inicializamos la barra de menu
		menuBar = new BarraMenu (this);
		this.setJMenuBar(menuBar);
		fondo = new ImageIcon("recursos/imagenes/menuFondo.png");
		this.setIconImage(fondo.getImage());
		
		Container contentPane = getContentPane();
				
		//Creamos los paneles
		contentPane.setLayout(new GridLayout(3,1));
		
		panelMenu = new PanelMenu(this);
		panelInfo = new PanelInfo();
		panelNombre = new PanelNombre();
		
		panelMenu.setOpaque(false);
		panelInfo.setOpaque(false);
		panelNombre.setOpaque(false);
		
		contentPane.add(panelInfo);
		contentPane.add(panelNombre);
		contentPane.add(panelMenu);
		paintComponents(this.getGraphics());
				
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand()=="nuevoJuego"){
			nuevoJuego();
		}
		else if (evento.getActionCommand()=="continuarJuego"){
			cargarJuego();
		}
		else if (evento.getActionCommand()=="salir"){
			System.exit(0);
		}
		else if (evento.getActionCommand()=="acerca"){
			acerca();
		}
		else if (evento.getActionCommand()=="ayuda"){
			ayuda();
		}
	}
	
	private void nuevoJuego(){
		
		VentanaJuego vJuego = new VentanaJuego();
		setVisible(false);
		vJuego.getFrame().setVisible(true);
		
	}
	
	private void cargarJuego(){
		VentanaJuego vJuego = new VentanaJuego("guardado.xml");
		setVisible(false);
		vJuego.getFrame().setVisible(true);
	}
	
	private void ayuda(){
		this.panelMenu.setTexto("Aca se informan las instrucciones del juego: ");
	}
	
	private void acerca(){
		this.panelMenu.setTexto("CopControl V 1.0  Integrantes:  " +
				"\nFederico Rodrigez Longhi,  \n" +
				"Nicolas Gatti, \n" +
				"Juan Manuel Orlando");
	}
}

