package vista.Ventanas;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

	private JPanel menu;
    private JButton botonJuegoNuevo;
    private JButton botonContinuarJuego;
    private JButton botonSalir;
    
    public VentanaPrincipal(){
        super();
        setSize(750,530);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;
        setLocation(x, y);
        menu = new JPanel();
        crearBotones();
        setVisible(true);
        setAlwaysOnTop(true);
    }
    
    private void crearBotones(){

        botonJuegoNuevo = new JButton("Juego Nuevo");
        botonContinuarJuego = new JButton("continuar juego");
        botonSalir = new JButton("Salir");
        menu.add(botonJuegoNuevo);
        menu.add(botonContinuarJuego);
        menu.add(botonSalir);
        menu.setLayout(new GridLayout(3,1));
    }
    
    public void pantallaUno (){
        menu.setVisible(true);
        add(menu);
        botonJuegoNuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;     menu.setVisible(false);
                //emepzarJuego
            }
        });

       /* botonContinuarJuego.addActionListener(new ActionListener(){
 	
        }); */

        botonSalir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ;     System.exit(0);
            }
        });
    }


}
