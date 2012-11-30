package Excepciones;

public class TiempoInsuficiente extends Exception {

	private static final long serialVersionUID = 1L;

	public TiempoInsuficiente() {
		super();
	}
	
	public TiempoInsuficiente(String msg) {
		super(msg);
	}

}
