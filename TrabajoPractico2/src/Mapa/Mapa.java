package Mapa;

import java.util.ArrayList;
import Aviones.Avion;
import Pistas.Pista;

public class Mapa {
	
	private ArrayList<Avion> aviones;
	private ArrayList<Pista> pistas;
	private double ancho;// ---
	private double largo;//  |
	
	public Mapa(double ancho, double largo){
		this.ancho = ancho;
		this.largo = largo;
		aviones = new ArrayList<Avion>();
		pistas = new ArrayList<Pista>();
	}
	
	public void agregarPista(Pista unaPista){
		pistas.add(unaPista);
	}
	
	public void agregarAvion(Avion unAvion){
		aviones.add(unAvion);
	}
	
}
