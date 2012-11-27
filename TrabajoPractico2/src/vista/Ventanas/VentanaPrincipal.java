package vista.Ventanas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ar.uba.fi.algo3.titiritero.vista.Panel;
import ar.uba.fi.algo3.titiritero.vista.Ventana;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import javax.swing.JButton;

public class VentanaPrincipal extends Ventana {

	public static final int EMPEZAR_JUEGO = 1;
	public static final int JUEGO_GRABADO = 2;
	
	private int seleccion;
	
	private Panel menu;
    private JButton botonJuegoNuevo;
    private JButton botonContinuarJuego;
    private JButton botonSalir;
    
    private static final long serialVersionUID = 1L;
    
    public VentanaPrincipal(ControladorJuego controlador){
    	super(800,600,controlador);
        menu = new Panel(400,300,controlador);
        crearBotones();
        seleccion = 0;
        setVisible(true);
        setAlwaysOnTop(true);
    }
    
    private void crearBotones(){

        botonJuegoNuevo = new JButton("Juego Nuevo");
        botonContinuarJuego = new JButton("Continuar Juego");
        botonSalir = new JButton("Salir");
        menu.add(botonJuegoNuevo);
        menu.add(botonContinuarJuego);
        menu.add(botonSalir);
        menu.setLayout(new GridLayout(3,1));
    }
    
    public void pantallaMenu (){
        menu.setVisible(true);
        add(menu);
        botonJuegoNuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;     menu.setVisible(false);
                seleccion = EMPEZAR_JUEGO; 
            }
        });

       /* botonContinuarJuego.addActionListener(new ActionListener(){
        * 
 	
        }); */

        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;     System.exit(0);
            }
        });
    }
    
    public int getSeleccion(){
    	return this.seleccion;
    }
}
