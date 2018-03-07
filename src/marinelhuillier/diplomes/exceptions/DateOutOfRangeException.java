package marinelhuillier.diplomes.exceptions;

import java.time.format.DateTimeFormatter;

import marinelhuillier.diplomes.Examen;

public class DateOutOfRangeException extends Exception {

	static DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public DateOutOfRangeException() {
		super("La date doit se situer dans la période d'examen : du "
				+ Examen.getDateDebutPeriodeExamen().format(datePattern) + " au "
				+ Examen.getDateFinPeriodeExamen().format(datePattern));
	}

}
