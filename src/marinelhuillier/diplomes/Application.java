package marinelhuillier.diplomes;

import java.time.LocalDate;
import java.util.List;

import marinelhuillier.diplomes.Diplome.Mention;
import marinelhuillier.diplomes.FiltrerExamens.Filtre;
import marinelhuillier.diplomes.exceptions.DateDayOfWeekException;
import marinelhuillier.diplomes.exceptions.DateOutOfRangeException;
import marinelhuillier.diplomes.exceptions.MoyNotesDiplomesNotEnoughtException;
import marinelhuillier.diplomes.exceptions.NbQuestionsQcmException;
import marinelhuillier.diplomes.exceptions.NbReponsesQcmOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NoteOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NotesProjetOutOfRangeException;

public class Application {

	public static void main(String[] args) throws NoteOutOfRangeException, NbQuestionsQcmException,
			NbReponsesQcmOutOfRangeException, NotesProjetOutOfRangeException, MoyNotesDiplomesNotEnoughtException,
			DateOutOfRangeException, DateDayOfWeekException {

		Diplome diplome = new Diplome();

		Examen examen = new Controle();
		examen.setNote(7);
		examen.setDate(LocalDate.of(2018, 02, 06));
		examen.setCode("EXAMEN6");

		Projet projet = new Projet();
		projet.setNote(7, 4);
		projet.setDate(LocalDate.of(2017, 11, 27));
		projet.setCode("PROJET12");

		Qcm qcm = new Qcm(24);
		qcm.setResponsesCorrecte(16);
		qcm.setDate(LocalDate.of(2018, 04, 13));
		qcm.setCode("QCM");

		// Possibilité d'ajouter des appreciations
		// examen.setAppreciation("Examen réussi, félicitations");
		// projet.setAppreciation("Peut mieux faire sur la partie ecrite");
		// qcm.setAppreciation(qcm.getNote());

		diplome.setExamens(examen, projet, qcm);

		diplome.afficherDetailsDesNotes();
		diplome.delivrer();
		diplome.getMention();

		if (diplome.isValide()) {
			Mention mention = diplome.getMention();
			System.out.println("Bravo, vous avez obtenu votre diplome ! - Mention : " + mention);
		}

		int noteDeComparaison = 12;

		System.out.println("Examens avec une note inferieure à : " + noteDeComparaison);
		List<Examen> result = diplome.getExamensAvecNoteInferieure(noteDeComparaison);
		System.out.println(result);

		Filtre filtre = Filtre.DATE;

		System.out.println("Tri par " + filtre + " :");
		diplome.getExamens(filtre);

	}
}
