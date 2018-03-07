package marinelhuillier.diplomes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import marinelhuillier.diplomes.exceptions.MoyNotesDiplomesNotEnoughtException;

public class Diplome {

	private float noteDiplome;

	private List<Examen> listeExamens = new ArrayList<>();
	private String appreciation = "";
	private float note = 0;

	public void setExamens(Examen... examens) {
		this.listeExamens.addAll(Arrays.asList(examens));
	}

	public void ajouterExamen(Examen examen) {
		listeExamens.add(examen);
	}

	public List<Examen> getExamensAvecNoteInferieure(float note) {
		List<Examen> examensAvecNoteInferieure = new ArrayList<>();
		for (Examen examen : listeExamens) {
			if (examen.getNote() <= note) {
				examensAvecNoteInferieure.add(examen);
			}
		}
		return examensAvecNoteInferieure;
	}

	public List<Examen> getExamensAvantDate(LocalDate date) {
		List<Examen> examensToRemove = new ArrayList<>();
		for (Examen examen : listeExamens) {
			if (examen.getDate().isBefore(date)) {
				examensToRemove.add(examen);
			}
		}
		return examensToRemove;
	}

	public void supprimerExamensAvantDate(LocalDate date) {
		listeExamens.removeAll(getExamensAvantDate(date));
	}

	public boolean isValide() {
		float total = 0;
		for (Examen examen : listeExamens) {
			total += examen.getNote();
		}
		this.noteDiplome = total / listeExamens.size();
		return this.noteDiplome >= 10;
	}

	public void delivrer() throws MoyNotesDiplomesNotEnoughtException {
		if (!isValide()) {
			throw new MoyNotesDiplomesNotEnoughtException();
		}
	}

	public void afficherDetailsDesNotes() {
		for (Examen examen : listeExamens) {
			note = examen.getNote();
			System.out.println(examen.getCode() + " :");
			System.out.println(examen.toString());
			// setAppreciations(examen);
		}
	}

	private void setAppreciations(Examen examen) {
		appreciation = examen.getAppreciation();
		System.out.println("Appreciation : " + appreciation);
	}

	public enum Mention {
		PASSABLE, BIEN, TRES_BIEN, EXCELLENT
	}

	public Mention getMention() {
		Mention mention = null;

		if (10 <= noteDiplome && noteDiplome < 12) {
			mention = Mention.PASSABLE;
		} else if (12 <= noteDiplome && noteDiplome < 14) {
			mention = Mention.BIEN;
		} else if (14 <= noteDiplome && noteDiplome < 16) {
			mention = Mention.TRES_BIEN;
		} else if (16 <= noteDiplome) {
			mention = Mention.EXCELLENT;
		}

		return mention;
	}

	@SuppressWarnings("unchecked")
	public Examen[] getExamens(FiltrerExamens.Filtre filtre) {
		Examen[] tableauExamens = listeExamens.toArray(new Examen[listeExamens.size()]);
		Arrays.sort(tableauExamens, new FiltrerExamens(filtre));

		System.out.println(Arrays.toString(tableauExamens));
		return tableauExamens;
	}
}
