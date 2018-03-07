package marinelhuillier.diplomes.exceptions;

public class NbReponsesQcmOutOfRangeException extends Exception {

	public NbReponsesQcmOutOfRangeException(int nbQuestions) {
		super("Le nombre de réponses du QCM doit être comrpis entre 0 et " + nbQuestions);
	}

}
