package marinelhuillier.diplomes.exceptions;

public class NoteOutOfRangeException extends Exception {

	public NoteOutOfRangeException() {
		super("La note doit être comprise entre 0 et 20");
	}

}
