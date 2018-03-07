package marinelhuillier.diplomes.exceptions;

public class NbReponsesQcmOutOfRangeException extends Exception {

	public NbReponsesQcmOutOfRangeException(int nbQuestions) {
		super("Le nombre de r�ponses du QCM doit �tre comrpis entre 0 et " + nbQuestions);
	}

}
