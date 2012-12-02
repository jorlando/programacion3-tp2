package vista.Ventanas;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import vista.Objetos.VistaMapa;

import modelo.Mapa.Mapa;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaJuego {
	private JFrame frame;
	private GameLoop gameLoop;
	private boolean juegoComenzado;
	private boolean pausa;
	
	private int FPS = 50;
	private int LARGO = 1024;
	private int ANCHO = 768;

	/**
	 * Launch the application.
	 */
	public JFrame getFrame() {
		return frame; 
	}

	/**
	 * Create the application.
	 */
	public VentanaJuego() {
		try {
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, LARGO, ANCHO);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("CopControl");
		frame.setResizable(false);
		
		JButton btnIniciar = this.addBotonIniciar();
		
		JButton btnPausa = this.addBotonDetener();
		
		JButton btnVolverAlMenu = this.addBotonVolver();
		
		JPanel panel = this.addSuperficiePanel();
		
		this.gameLoop = new GameLoop(FPS,(SuperficieDeDibujo) panel);
		
		this.inicializarModelo();
		
		this.addMouseListener(panel);
		
		this.addKeyListener();

		this.setComponentsFocus(btnIniciar, btnPausa, btnVolverAlMenu); //esto nose para que sirve
		
		this.pausa = true;
		
		this.juegoComenzado = false;
		
	}

	private void inicializarModelo() throws MalformedURLException, IOException {
		
		Mapa unMapa = new Mapa();
		VistaMapa vista = new VistaMapa(unMapa);
		
		this.gameLoop.agregar(unMapa);
		this.gameLoop.agregar(vista);
		

	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener, JButton btnVolver) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
		btnVolver.setFocusable(false);
	}

	private void addKeyListener() {
		frame.addKeyListener(new KeyListener(
				) {
			
			@Override
			public void keyTyped(KeyEvent eventoTyped) {
				System.out.println("Key pressed");
			}
			
			@Override
			public void keyReleased(KeyEvent eventoRelease) {
			}
			
			@Override
			public void keyPressed(KeyEvent eventoPress) {
				System.out.println("Ping");
			}  
			 	
		});
	}

	private void addMouseListener(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent eventoMouse) {
				//la idea aca es que busque en el mapa un avion cercano a ese punto e inicie una tryectoria. 
				Point posicion = eventoMouse.getLocationOnScreen(); //este punto es el que hay que agregar a la trayectoria
				int x = posicion.x;
				int y = posicion.y;
				System.out.println(x+","+y);
				
			}});
		
	}

	private JPanel addSuperficiePanel() {
		JPanel panel = new SuperficiePanel();
		panel.setBackground(new Color(100, 200, 50));
		panel.setBounds(0, 50,(LARGO),(ANCHO));
		frame.getContentPane().add(panel);
		return panel;
	}
	
	private JButton addBotonDetener() {
		JButton btnPausa = new JButton("Pausa");
		btnPausa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (juegoComenzado){
					if (pausa){
						gameLoop.iniciarEjecucion();
						((JButton)e.getSource()).setBackground(Color.green); //esto es medio feo pero fue la unica manera que encontre de hacerlo.
						pausa = false;
					}
					else{
						gameLoop.detenerEjecucion();
						((JButton)e.getSource()).setBackground(Color.red);
						pausa = true;
					}
				}
			}
		});
		
		btnPausa.setBounds(280, 16, 92, 25);
		btnPausa.setBackground(Color.green);
		frame.getContentPane().add(btnPausa);
		return btnPausa;
	}

	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Comenzar Juego");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameLoop.iniciarEjecucion();
				pausa = false;
				juegoComenzado = true;
				((JButton)e.getSource()).setVisible(false);
			}
		});
		btnIniciar.setBounds(42, 16, 200, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
	private JButton addBotonVolver() {
		JButton btnIniciar = new JButton("Volver Al Menu");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (juegoComenzado){
					gameLoop.detenerEjecucion();
				}
				frame.setVisible(false);
				VentanaPrincipal ventana = new VentanaPrincipal();
				ventana.iniciar();
			}
		});
		btnIniciar.setBounds(800, 16, 200, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
}

