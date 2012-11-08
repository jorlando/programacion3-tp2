package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;

public interface EstrategiaAvion
{
	public Vector Avanzar(Vector posicion, double Velocidad, Trayectoria trayectoriaDeVuelo);
}
