package vista.Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import persistencia.Archivador;

import vista.Ventanas.Menu.PanelInfo;
import vista.Ventanas.Menu.PanelMenu;
import vista.Ventanas.Menu.PanelNombre;
import vista.Ventanas.Menu.PanelPuntaje;

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
	JTextArea texto;
	JPanel panel;
	PanelPuntaje puntajePanel;
	
	private int FPS = 50;
	private int LARGO = 1000;
	private int ANCHO = 700;

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
			initialize();	//inicializacion general
			GameLoop gameLoop = new GameLoop(FPS,(SuperficieDeDibujo) panel);
			this.inicializarModelo(gameLoop);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public VentanaJuego(String pathArchivoXML)
	{
		try 
		{
			initialize();	//inicializacion general
			GameLoop gameLoop = new GameLoop(FPS,(SuperficieDeDibujo) panel);
			this.inicializarModelo(gameLoop, pathArchivoXML);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setForeground(Color.black);
		frame.setBounds(100, 100, LARGO, ANCHO);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("CopControl");
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JButton btnIniciar = this.addBotonIniciar();
		JButton btnPausa = this.addBotonDetener();
		JButton btnReiniciar = this.addBotonReiniciar();
		JButton btnVolverAlMenu = this.addBotonVolver();
				
		panel = this.addSuperficiePanel();
		
		panel.setBounds(50, 50, LARGO-100, ANCHO-100);

		this.addMouseListener(panel);
		this.addMouseMotionListener(panel);
		
		this.setComponentsFocus(btnIniciar, btnPausa, btnVolverAlMenu, btnReiniciar);
		
		/* inicializando variables*/
		this.pausa = true;
		this.juegoEnProgreso = false;
		this.trazandoTrayectoria = false;
		this.avion = null;
		
		
		Container contentPane = frame.getContentPane();
		
		//Creamos los paneles
		contentPane.setLayout(new BorderLayout());
		puntajePanel = PanelPuntaje.obtenerPanel();
		puntajePanel.setOpaque(true);
		contentPane.add("East",puntajePanel);
			
	}

	private void inicializarModelo(GameLoop gameLoop) {
		
		this.mapa = new Mapa(ANCHO-100,LARGO-100 , gameLoop);
	}

	private void inicializarModelo(GameLoop gameLoop, String pathArchivoXML) throws IOException
	{
		this.mapa = Archivador.cargarMapa(pathArchivoXML, gameLoop);	
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
			public void mousePressed(MouseEvent e) {
				Vector click = new Vector(e.getX(),e.getY());
				//System.out.println(click.getX()+","+click.getY());
				if (trazandoTrayectoria){
					avion.agregarPuntoATrayectoria(click);
				}
				else{
					avion = mapa.obtenerAvionEn(click);
					if ((avion != null) && (avion.trayectoriaModificable())){				
						avion.limpiarTrayectoria();
						avion.agregarPuntoATrayectoria(click);
						trazandoTrayectoria = true;
					}
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				trazandoTrayectoria = false;
				avion = null;
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				trazandoTrayectoria = false;
				avion = null;
			}
		});
	}
	
	private void addMouseMotionListener(JPanel panel) {
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
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
			@Override
			public void actionPerformed(ActionEvent e) {
				if (juegoEnProgreso){
					if (pausa){
						mapa.iniciarSimulacion();
						((JButton)e.getSource()).setText("Pausa");
						((JButton)e.getSource()).setBackground(Color.red);
						pausa = false;
					}
					else{
						mapa.detenerSimulacion();
						((JButton)e.getSource()).setText("Reanudar");
						((JButton)e.getSource()).setBackground(Color.green);
						pausa = true;
					}
				}
			}
		});
		
		btnPausa.setBounds(280, 16, 92, 25);
		btnPausa.setBackground(Color.red);
		frame.getContentPane().add(btnPausa);
		return btnPausa;
	}

	private JButton addBotonIniciar() {
		JButton btnIniciar = new JButton("Comenzar Juego");
		btnIniciar.addActionListener(new ActionListener() {
			@Override
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (juegoEnProgreso){
					System.out.println("Guardando el juego...");
					Archivador.guardar(mapa, "guardado.xml");	//guardo el juego
					System.out.println("Guardando el juego...OK! ;)");
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
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (juegoEnProgreso){
					mapa.detenerSimulacion();
					frame.setVisible(false);
					VentanaJuego vJuego = new VentanaJuego();
					vJuego.getFrame().setVisible(true);
					//reseteo los valores del panel de puntaje
					PanelPuntaje.obtenerPanel().reiniciar();
					}
				
			}
		});
		btnIniciar.setBounds(500, 16, 200, 25);
		frame.getContentPane().add(btnIniciar);
		return btnIniciar;
	}
	
	
}

