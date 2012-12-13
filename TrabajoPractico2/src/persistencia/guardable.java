package persistencia;

import org.jdom2.Element;

public interface guardable 
{
	public abstract Element serializarXML();
}
