package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;
import Pistas.Pista;

public interface EstrategiaAvion
{
	public Vector Avanzar(Vector posicion, double Velocidad, Trayectoria trayectoriaDeVuelo);
	public boolean puedeAterrizarEn(Pista unaPista);
}
