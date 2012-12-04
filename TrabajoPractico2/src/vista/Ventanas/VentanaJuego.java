package vista.Ventanas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Mapa.Mapa;

import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class VentanaJuego {
	private JFrame frame;
	private Mapa mapa;
	private boolean juegoEnProgreso;
	private boolean pausa;
	private boolean trazandoTrayectoria;
	
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
		
		JButton btnReiniciar = this.addBotonReiniciar();
		
		JPanel panel = this.addSuperficiePanel();
		
		panel.setBounds(50, 50, LARGO-100, ANCHO-100);
		
		GameLoop gameLoop = new GameLoop(FPS,(SuperficieDeDibujo) panel);
		
		this.inicializarModelo(gameLoop);
		
		this.addMouseListener(panel);
		
		this.setComponentsFocus(btnIniciar, btnPausa, btnVolverAlMenu, btnReiniciar); //esto nose para que sirve
		
		this.pausa = true;
		
		this.juegoEnProgreso = false;
		
		this.trazandoTrayectoria = false;
		
	}

	private void inicializarModelo(GameLoop gameLoop) {
		
		mapa = new Mapa(gameLoop);

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
					
			@Override
			public void mouseClicked(MouseEvent eventoMouse) {

				trazandoTrayectoria = true;
				
			}
			
			public void mouseDragged(MouseEvent eventoMouse) {
				//la idea aca es que busque en el mapa un avion cercano a ese punto e inicie una tryectoria. 
				if (trazandoTrayectoria){
					int x = eventoMouse.getX();
					int y = eventoMouse.getY();
					System.out.println(x+","+y);
				}
				
			}
		
			public void mouseReleased(MouseEvent eventoMouse) {
				trazandoTrayectoria = false;
			}
			
			public void mouseExited(MouseEvent e) {
		        trazandoTrayectoria = false;
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

