package Excepciones;

public class ImposibleCrearAvion extends Exception {

	private static final long serialVersionUID = 1L;

	public ImposibleCrearAvion() {
	}

	public ImposibleCrearAvion(String message) {
		super(message);
	}

}
