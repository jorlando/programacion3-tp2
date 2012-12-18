package modelo.Mapa;

import org.jdom2.Element;

import persistencia.guardable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Nivel implements ObjetoVivo, guardable

{
	private static final int TIEMPO_MAXIMO_PARA_CREAR_AVIONES = 100;
	private int nivelActual;
	private double factorVelocidad;
	private int avionesPorNivel;
	private int avionesAterrizados;
	private int contadorParaAviones;	//cicla cada cuando se agregan aviones mientras mas niveles mas seguido
	
	public Nivel()
	{
		avionesAterrizados = 0;
		nivelActual = 1;
		contadorParaAviones = TIEMPO_MAXIMO_PARA_CREAR_AVIONES;
		this.reparametrizar();
	}
	
	public int getNivel()
	{
		return nivelActual;
	}
	
	public double getFactorVelocidad()
	{
		return factorVelocidad;
	}
	
	public void AvionAterrizado() 
	{
		avionesAterrizados++;
		
		if(avionesAterrizados >= avionesPorNivel)
			this.siguienteNivel();
	}
	
	public void AvionesAterrizados(int cantidad){
		for(int x=0;x<cantidad;x++){
			this.AvionAterrizado();
		}
	}
	
	public boolean debeGenerarAvion()
	{
		return (contadorParaAviones == 0);
	}

	private void reparametrizar() 
	{
		calcularFactorVelocidad();
		calcularAvionesPorNivel();
	}

	private void calcularAvionesPorNivel() 
	{
		avionesPorNivel = nivelActual * 4;
	}

	private void calcularFactorVelocidad() 
	{
		factorVelocidad = 1 + (nivelActual * nivelActual);
	}
	
	private void calcularContadorParaAviones() {
		
		contadorParaAviones = TIEMPO_MAXIMO_PARA_CREAR_AVIONES /(nivelActual*nivelActual);
	}
	
	private void siguienteNivel()
	{
		nivelActual++;
		this.reparametrizar();
	}
	
	@Override
	public void vivir()
	{
		if (contadorParaAviones == 0)
			calcularContadorParaAviones();
		else
			contadorParaAviones--;
	}
	
	public int obtenerAvionesAterrizados(){
		return this.avionesAterrizados;
	}

	@Override
	public Element serializarXML() {
		Element elementoNivel = new Element("Nivel");
		
		elementoNivel.setAttribute("nivelActual", String.valueOf(this.nivelActual));
		elementoNivel.setAttribute("factorVelocidad", String.valueOf(this.factorVelocidad));
		elementoNivel.setAttribute("avionesPorNivel", String.valueOf(this.avionesPorNivel));
		elementoNivel.setAttribute("contadorParaAviones", String.valueOf(this.contadorParaAviones));
		elementoNivel.setAttribute("avionesAterrizados", String.valueOf(this.avionesAterrizados));
		
		return elementoNivel;
	}
	
	public static Nivel cargarDesdeXML (Element elementoNivel)
	{
		Nivel nuevoNivel = new Nivel();
		nuevoNivel.nivelActual = Integer.parseInt(elementoNivel.getAttributeValue("nivelActual"));
		nuevoNivel.factorVelocidad = Double.parseDouble(elementoNivel.getAttributeValue("factorVelocidad"));
		nuevoNivel.avionesPorNivel = Integer.parseInt(elementoNivel.getAttributeValue("avionesPorNivel"));
		nuevoNivel.contadorParaAviones = Integer.parseInt(elementoNivel.getAttributeValue("contadorParaAviones"));
		nuevoNivel.avionesAterrizados = Integer.parseInt(elementoNivel.getAttributeValue("avionesAterrizados"));
		
		return nuevoNivel;
	}
}
