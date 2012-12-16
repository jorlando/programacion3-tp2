package NivelTest;

import persistencia.Archivador;
import modelo.Mapa.Nivel;
import junit.framework.TestCase;

public class NivelTest extends TestCase 
{
	public void testPersistenciaNivel()
	{
		
		String pathArchivo = "srcTestUnitarios//NivelTest//pruebaNivel.xml";
		Nivel nivelDePrueba = new Nivel();
		
		Archivador.guardar(nivelDePrueba, pathArchivo);
		
		Nivel nuevoNivel = Archivador.cargarNivel(pathArchivo);
		
		boolean pruebaCorrecta = nivelDePrueba.getNivel() ==nuevoNivel.getNivel();
		
		pruebaCorrecta &= nivelDePrueba.getFactorVelocidad() == nuevoNivel.getFactorVelocidad();
		pruebaCorrecta &= nivelDePrueba.obtenerAvionesAterrizados() == nuevoNivel.obtenerAvionesAterrizados();
		
		assertTrue(pruebaCorrecta);
	}

}
