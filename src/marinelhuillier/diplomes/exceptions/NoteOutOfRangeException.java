package marinelhuillier.diplomes.exceptions;

public class NoteOutOfRangeException extends Exception {

	public NoteOutOfRangeException() {
		super("La note doit �tre comprise entre 0 et 20");
	}

}
