package modelo.Mapa;

public class Nivel 

{
	private int nivelActual;
	private double factorVelocidad;
	private int avionesPorNivel;
	private int avionesAterrizados;
	
	public Nivel()
	{
		avionesAterrizados = 0;
		nivelActual = 1;
		this.reparametrizar();
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

	public double getFactorVelocidad()
	{
		return factorVelocidad;
	}
	
	private void siguienteNivel()
	{
		nivelActual++;
		this.reparametrizar();
	}

	public void AvionAterrizado() 
	{
		avionesAterrizados++;
		
		if(avionesAterrizados == avionesPorNivel)
			this.siguienteNivel();
	}
}
