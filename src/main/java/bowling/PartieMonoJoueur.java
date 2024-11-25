package bowling;

import java.util.ArrayList;
import java.util.List;

public class PartieMonoJoueur {

	private List<Tour> tours;
	private int tourCourant;

	public PartieMonoJoueur() {
		this.tours = new ArrayList<>();
		this.tourCourant = 1;
	}

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (estTerminee()) {
			throw new IllegalStateException("La partie est déjà terminée.");
		}
		if (tourCourant > 10) {
			throw new IllegalStateException("La partie est terminée après 10 tours.");
		}

		Tour tourCourantObj = obtenirTour();
		boolean continuerTour = tourCourantObj.enregistreLancer(nombreDeQuillesAbattues);

		if (tourCourantObj.estTerminee()) {
			tourCourant++;
		}
		return !tourCourantObj.estTerminee();
	}

	public int score() {
		int scoreTotal = 0;
		for (int i = 0; i < tours.size(); i++) {
			scoreTotal += tours.get(i).score();
		}
		if (!estTerminee()) {
			scoreTotal += (10 - tours.size()) * 0;
		}
		return scoreTotal;
	}

	public boolean estTerminee() {
		return tourCourant > 10;
	}

	public int numeroTourCourant() {
		return estTerminee() ? 0 : tourCourant;
	}

	public int numeroProchainLancer() {
		return estTerminee() ? 0 : obtenirTour().numeroProchainLancer();
	}

	private Tour obtenirTour() {
		if (tours.size() < tourCourant) {
			tours.add(new Tour());
		}
		return tours.get(tourCourant - 1);
	}
}
