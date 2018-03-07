package marinelhuillier.diplomes.exceptions;

public class NbQuestionsQcmException extends Exception {

	public NbQuestionsQcmException() {
		super("Votre QCM ne comporte pas assez de questions");
	}

}
