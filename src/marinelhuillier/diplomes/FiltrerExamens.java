package marinelhuillier.diplomes;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class FiltrerExamens implements Comparator {

	public enum Filtre {
		CODE, NOTE, DATE
	}

	public int resultatComparaison;
	private Filtre filtre;

	public FiltrerExamens(Filtre filtre) {
		this.filtre = filtre;
	}

	@Override
	public int compare(Object param1, Object param2) {

		Examen examen1 = (Examen) param1;
		Examen examen2 = (Examen) param2;

		switch (filtre) {
		case CODE:
			resultatComparaison = examen1.getCode().compareTo(examen2.getCode());
			break;
		case NOTE:
			resultatComparaison = compare(examen1.getNote(), examen2.getNote());
			break;
		case DATE:
			resultatComparaison = examen1.getDate().compareTo(examen2.getDate());
			break;
		}
		return resultatComparaison;
	}

}
