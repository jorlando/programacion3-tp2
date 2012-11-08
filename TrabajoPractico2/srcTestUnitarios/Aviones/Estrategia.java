package Aviones;

public class Estrategia
{

	private static EstrategiaAvionSimple tipoAvionSimple;
	
	public static EstrategiaAvion AvionSimple()
	{
		if (tipoAvionSimple == null)
			tipoAvionSimple = new EstrategiaAvionSimple();
		
		return tipoAvionSimple;
		
	}
	
}
