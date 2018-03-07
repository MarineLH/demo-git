package marinelhuillier.diplomes.exceptions;

public class NotesProjetOutOfRangeException extends Exception {

	public NotesProjetOutOfRangeException() {
		super("Les notes (écrit et oral) du projet doivent être comprises entre 0 et 10.");
	}
}
