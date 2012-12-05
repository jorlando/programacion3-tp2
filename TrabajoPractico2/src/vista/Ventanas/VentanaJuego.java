package vista.Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Aviones.Avion;
import modelo.Mapa.Mapa;
import modelo.Utilitarios.Vector;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaJuego {
	private JFrame frame;
	private Mapa mapa;
	private boolean juegoEnProgreso;
	private boolean pausa;
	private boolean trazandoTrayectoria;
	private Avion avion;
	
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
		JButton btnReiniciar = this.addBotonReiniciar();
		JButton btnVolverAlMenu = this.addBotonVolver();
				
		JPanel panel = this.addSuperficiePanel();
		panel.setBounds(50, 50, LARGO-100, ANCHO-100);
		/*Inicializando el gameloop*/
		GameLoop gameLoop = new GameLoop(FPS,(SuperficieDeDibujo) panel);
			
		this.inicializarModelo(gameLoop);
		
		/**/ 
		this.addMouseListener(panel);
		this.addMouseMotionListener(panel);
		
		this.setComponentsFocus(btnIniciar, btnPausa, btnVolverAlMenu, btnReiniciar);
		
		/* inicializando variables*/
		this.pausa = true;
		this.juegoEnProgreso = false;
		this.trazandoTrayectoria = false;
		this.avion = null;
		
	}

	private void inicializarModelo(GameLoop gameLoop) {
		
		this.mapa = new Mapa(LARGO-100, ANCHO-100, gameLoop);

	}

	private void setComponentsFocus(JButton btnIniciar, JButton btnDetener, JButton btnVolver, JButton btnReiniciar) {
		frame.setFocusable(true);
		btnDetener.setFocusable(false);
		btnIniciar.setFocusable(false);
		btnVolver.setFocusable(false);
		btnReiniciar.setFocusable(false);
	}


	private void addMouseListener(JPanel panel) {
		panel.addMouseListener(new MouseAdapter() {	
						
			public void mouseClicked(MouseEvent e) {
				System.out.println("The frame was clicked.");
				
			}
			
			public void mouseEntered(MouseEvent e) {
				System.out.println("The mouse entered the frame.");
				
			}
			
			public void mouseExited(MouseEvent e) {
				System.out.println("The mouse exited the frame.");
				
			}
			
			public void mousePressed(MouseEvent e) {
				System.out.println("The left mouse button was pressed.");
				Vector click = new Vector(e.getX(),e.getY());
				if (trazandoTrayectoria){
					avion.agregarPuntoATrayectoria(click);
				}
				else{
					avion = mapa.obtenerAvionEn(click);
					if (avion != null){
						System.out.println("encontramos un avion");					
						avion.limpiarTrayectoria();
						avion.agregarPuntoATrayectoria(click);
						trazandoTrayectoria = true;
					}
				}
			}
			
			public void mouseReleased(MouseEvent e) {
				trazandoTrayectoria = false;
				avion = null;
				System.out.println("The left mouse button was released.");
				
			}		
		});
	}
	
	private void addMouseMotionListener(JPanel panel) {
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				//System.out.println("The left mouse button is being dragged.");
				if (trazandoTrayectoria){
					avion.agregarPuntoATrayectoria(new Vector(e.getX(),e.getY()));
				}
				
			}
			
		});
		
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
				if (juegoEnProgreso){
					if (pausa){
						mapa.iniciarSimulacion();
						((JButton)e.getSource()).setBackground(Color.green); //esto es medio feo pero fue la unica manera que encontre de hacerlo.
						pausa = false;
					}
					else{
						mapa.detenerSimulacion();
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
				mapa.iniciarSimulacion();
				pausa = false;
				juegoEnProgreso = true;
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
				if (juegoEnProgreso){
					mapa.detenerSimulacion();
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
	
	private JButton addBotonReiniciar() {
		JButton btnIniciar = new JButton("Reiniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (juegoEnProgreso){
					mapa.detenerSimulacion();
					frame.setVisible(false);
					VentanaJuego vJuego = new VentanaJuego();
					vJuego.getFrame().setVisible(true);
				}
				
			}
		});
		btnIniciar.setBounds(500, 16, 200, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
}

