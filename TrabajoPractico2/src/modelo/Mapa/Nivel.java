package modelo.Mapa;

import Excepciones.ImposibleCalcularPosicion;
import Excepciones.ImposibleCrearAvion;
import Excepciones.TiempoInsuficiente;
import modelo.Aviones.*;
import modelo.Utilitarios.Vector;

public class Nivel {
	
	private int nivel; 
	private int intervaloTiempo; // cuanto tiempo(hay que ver como se mide) tiene que pasar para agregar un avion.
	private int tiempoUltimoAvion; // cuanto paso desde que agregamos el ultimo avion.
	private int velocidadAviones; //velocidad con la que los aviones aparecen.
	
	public Nivel(){
		this.nivel = 1;
		this.intervaloTiempo = 1; //hay que ver como manejamos esto
		this.velocidadAviones = 1; //es por lo que se multiplica la velocidad estandar de los aviones
		this.tiempoUltimoAvion = 0;
	}
	
	public Avion agregarNuevoAvion(Mapa unMapa) throws TiempoInsuficiente, ImposibleCrearAvion {
		
		if (tiempoUltimoAvion >= intervaloTiempo){
			/* Aca deberia lanzar una excepcion si no se puede calcular una nueva posicion*/ 
			try{
				Vector posicion = calcularNuevaPosicion(unMapa);
				Vector direccion = calcularNuevaDireccion(unMapa, posicion);
				EstrategiaAvion tipo = calcularNuevoTipoDeAvion();
				return new Avion(posicion,direccion,4,tipo);
			}
			catch (ImposibleCalcularPosicion ex){
				throw (new ImposibleCrearAvion());
			}
		}
		
		else throw (new TiempoInsuficiente("se requiere mas tiempo para crear un avion"));
	}
	
	public void avanzarNivel(){
		this.nivel++;
	}
		
	private Vector calcularNuevaPosicion(Mapa unMapa) throws ImposibleCalcularPosicion{
		try{
			return unMapa.obtenerPosicionLibre();
		}
		catch (ImposibleCalcularPosicion ex){
			throw (ex);
		}
	}
	
	private Vector calcularNuevaDireccion(Mapa unMapa, Vector unaPosicion){
		return unMapa.calcularDireccionParaPosicion(unaPosicion);
	}
	
	private EstrategiaAvion calcularNuevoTipoDeAvion(){
		//por ahora salen todos aviones simples
		return new EstrategiaAvionSimple();
	}
	
}
