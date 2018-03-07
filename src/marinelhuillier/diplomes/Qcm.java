package marinelhuillier.diplomes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import marinelhuillier.diplomes.exceptions.DateOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NbQuestionsQcmException;
import marinelhuillier.diplomes.exceptions.NbReponsesQcmOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NoteOutOfRangeException;

public class Qcm extends Examen {

	private int nbQuestions;
	private String appreciation = "";
	private float note;
	private LocalDate date;
	private String code;
	DateTimeFormatter frenchDatePattern = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRANCE);

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Qcm(int nbQuestions) throws NbQuestionsQcmException {
		if (nbQuestions < 1) {
			throw new NbQuestionsQcmException();
		}
		this.nbQuestions = nbQuestions;
	}

	public void setResponsesCorrecte(int reponse) throws NbReponsesQcmOutOfRangeException, NoteOutOfRangeException {
		if (reponse < 0 || reponse > nbQuestions) {
			throw new NbReponsesQcmOutOfRangeException(nbQuestions);
		}
		setNote(reponse / (float) nbQuestions * 20);
	}

	public String getAppreciation() {
		return appreciation;
	}

	public String setAppreciation(float note) {

		if (note < 8) {
			appreciation = "insuffisant";
		} else if (8 <= note && note < 12) {
			appreciation = "passable";
		} else if (12 <= note && note < 16) {
			appreciation = "bien";
		} else {
			appreciation = "très bien";
		}
		return appreciation;
	}

	public void setDate(LocalDate date) throws DateOutOfRangeException {
		if (!IsValideDate(date)) {
			throw new DateOutOfRangeException();
		}
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public boolean IsValideDate(LocalDate date) {
		return !date.isBefore(Examen.getDateDebutPeriodeExamen()) && !date.isAfter(Examen.getDateFinPeriodeExamen());
	}

	@Override
	public String toString() {
		note = getNote();
		String noteFormated = String.format("%.2f", note);
		if (note < 10) {
			noteFormated = String.format("0%.2f", note);
		}
		return noteFormated + "/20 au QCM du " + date.format(frenchDatePattern);
	}

}
