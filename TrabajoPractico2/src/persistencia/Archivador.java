package persistencia;

import modelo.Aviones.Avion;
import modelo.Utilitarios.Trayectoria;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

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

}