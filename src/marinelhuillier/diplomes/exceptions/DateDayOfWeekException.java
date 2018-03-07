package marinelhuillier.diplomes.exceptions;

public class DateDayOfWeekException extends Exception {

	public DateDayOfWeekException() {
		super("La date d'un examen ne peut pas tomber un samedi ou un dimanche");
	}

}
