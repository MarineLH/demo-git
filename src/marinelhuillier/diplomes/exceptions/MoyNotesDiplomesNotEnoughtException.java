package marinelhuillier.diplomes.exceptions;

public class MoyNotesDiplomesNotEnoughtException extends Exception {

	public MoyNotesDiplomesNotEnoughtException() {
		super("La moyenne de tous les examens est inf�rieure � 10.");
	}
}
