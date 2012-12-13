package modelo.Mapa;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class Nivel implements ObjetoVivo

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
}
