package marinelhuillier.diplomes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import marinelhuillier.diplomes.exceptions.DateOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NoteOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NotesProjetOutOfRangeException;

public class Projet extends Examen {
	private float note;
	private String appreciation = "";
	private LocalDate date;
	private String code;
	DateTimeFormatter frenchDatePattern = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRANCE);

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setNote(float oral, float ecrit) throws NotesProjetOutOfRangeException, NoteOutOfRangeException {
		if (oral < 0 || oral > 10 || ecrit < 0 || ecrit > 10) {
			throw new NotesProjetOutOfRangeException();
		}
		this.setNote(oral + ecrit);
	}

	public String getAppreciation() {

		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
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
		return noteFormated + "/20 au Projet du " + date.format(frenchDatePattern);
	}
}