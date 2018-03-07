package marinelhuillier.diplomes;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import marinelhuillier.diplomes.exceptions.DateDayOfWeekException;
import marinelhuillier.diplomes.exceptions.DateOutOfRangeException;
import marinelhuillier.diplomes.exceptions.NoteOutOfRangeException;

public abstract class Examen {

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

	public float getNote() {
		return note;
	}

	public void setNote(float note) throws NoteOutOfRangeException {
		if (note < 0 || note > 20) {
			throw new NoteOutOfRangeException();
		}
		this.note = note;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public void setDate(LocalDate date) throws DateOutOfRangeException, DateDayOfWeekException {
		if (!IsValideDate(date)) {
			throw new DateOutOfRangeException();
		}
		if (!isNotSaturdayOrSunday(date)) {
			throw new DateDayOfWeekException();
		}
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public static LocalDate getDateDebutPeriodeExamen() {
		// default year
		LocalDate date = LocalDate.now();
		int year = date.getYear();

		// if second part of exam period : year -1
		if (1 <= date.getMonthValue() && date.getMonthValue() <= 6) {
			year = date.plusYears(-1).getYear();
		}
		return LocalDate.of(year, 10, 1);
	}

	public static LocalDate getDateFinPeriodeExamen() {
		// default year
		LocalDate date = LocalDate.now();
		int year = date.getYear();

		// if period between last exam period and current first perdio exam
		if (7 <= date.getMonthValue() && date.getMonthValue() <= 12) {
			year = date.plusYears(1).getYear();
		}
		return LocalDate.of(year, 6, 30);
	}

	public static boolean isNotSaturdayOrSunday(LocalDate date) {
		if (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) {
			return false;
		}
		return true;
	}

	public boolean IsValideDate(LocalDate date) {
		return !date.isBefore(Examen.getDateDebutPeriodeExamen()) && !date.isAfter(Examen.getDateFinPeriodeExamen());
	}

	@Override
	public String toString() {
		String noteFormated = String.format("%.2f", note);
		if (note < 10) {
			noteFormated = String.format("0%.2f", note);
		}
		return noteFormated + "/20 à l'Examen du " + date.format(frenchDatePattern);
	}
}
