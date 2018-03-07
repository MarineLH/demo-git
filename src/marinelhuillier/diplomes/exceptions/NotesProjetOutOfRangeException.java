package marinelhuillier.diplomes.exceptions;

public class NotesProjetOutOfRangeException extends Exception {

	public NotesProjetOutOfRangeException() {
		super("Les notes (�crit et oral) du projet doivent �tre comprises entre 0 et 10.");
	}
}
