package Aviones;

import Utilitarios.Trayectoria;
import Utilitarios.Vector;
import Pistas.Pista;

public interface EstrategiaAvion
{
	public Vector avanzar(Vector posicion, double Velocidad, Trayectoria trayectoriaDeVuelo);
	public boolean puedeAterrizarEn(Pista unaPista);
	public boolean calcularChoqueCon(Avion unAvion); //este metodo lo unico que hace es devolver true, y por ahora es medio obsoleto, pero si le queremos agregar aviones que choquen dependiendo el tipo es mucho mas facil de implementar. 
}