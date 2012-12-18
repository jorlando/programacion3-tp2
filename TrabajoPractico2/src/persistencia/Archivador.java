package persistencia;

import modelo.Aviones.Avion;
import modelo.Mapa.Mapa;
import modelo.Mapa.Nivel;
import modelo.Utilitarios.Trayectoria;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

import vista.Aviones.VistaAvion;

import fiuba.algo3.titiritero.modelo.GameLoop;

public class Archivador {
	
	public static void guardar(guardable unGuardable, String pathArchivo) {
		try {
	        
			Element root = unGuardable.serializarXML();
	        Document document = new Document(root);

	        XMLOutputter outputter = new XMLOutputter();
	        outputter.setFormat(Format.getPrettyFormat());
	        
	        FileWriter writer = new FileWriter(pathArchivo);
	        outputter.output(document,writer);
	        writer.close();
	        
	        
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static Avion cargarAvion(String pathArchivo) {
	
		SAXBuilder builder = new SAXBuilder();
	    Document document;
		try 
		{
			document = builder.build(pathArchivo);
		} 
		catch (JDOMException | IOException e)
		{
			e.printStackTrace();
			return null;
		}
	     
	    return Avion.cargarDesdeXML(document.getRootElement());
	}

	public static Trayectoria cargarTrayectoria(String pathArchivo) 
	{
		SAXBuilder builder = new SAXBuilder();
	    Document document;
		try 
		{
			document = builder.build(pathArchivo);
		} 
		catch (JDOMException | IOException e)
		{
			e.printStackTrace();
			return null;
		}
	     
	     return Trayectoria.cargarDesdeXML(document.getRootElement());
	}

	public static Nivel cargarNivel(String pathArchivo)
	{
		SAXBuilder builder = new SAXBuilder();
	    Document document;
		try 
		{
			document = builder.build(pathArchivo);
		} 
		catch (JDOMException | IOException e)
		{
			e.printStackTrace();
			return null;
		}
	     
	    return Nivel.cargarDesdeXML(document.getRootElement());
	}

	public static Mapa cargarMapa(String pathArchivoXML, GameLoop gameLoop) throws IOException
	{
		SAXBuilder builder = new SAXBuilder();
	    Document document;
		try 
		{
			document = builder.build(pathArchivoXML);
		} 
		catch (JDOMException | IOException e)
		{
			e.printStackTrace();
			return null;
		}
		
		Element elementoMapa = document.getRootElement();
	    
		int ancho =  Integer.parseInt(elementoMapa.getAttributeValue("ancho"));
		int largo = Integer.parseInt(elementoMapa.getAttributeValue("largo"));
		
		Mapa nuevoMapa = new Mapa(ancho, largo, gameLoop, Nivel.cargarDesdeXML(elementoMapa.getChild("Nivel")));
		
		Iterator<Element> avionesACargar = elementoMapa.getChild("Aviones").getChildren().iterator();
		while(avionesACargar.hasNext())
		{
			Element proximoAvion = avionesACargar.next();
			Avion nuevoAvion = Avion.cargarDesdeXML(proximoAvion);
			nuevoMapa.agregarAvion(nuevoAvion);
			gameLoop.agregar(nuevoAvion);
			VistaAvion vistaAvion = new VistaAvion(nuevoAvion);
			gameLoop.agregar(vistaAvion);
		}
		return nuevoMapa;

	}
}