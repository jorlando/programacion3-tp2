package Excepciones;

public class ImposibleCalcularPosicion extends Exception {

	private static final long serialVersionUID = 1L;

	public ImposibleCalcularPosicion() {
	}

	public ImposibleCalcularPosicion(String msg) {
		super(msg);
	}

}
