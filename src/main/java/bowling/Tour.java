package bowling;

public class Tour {

	private int[] lancers;
	private int lancerActuel;

	public Tour() {
		this.lancers = new int[3];
		this.lancerActuel = 0;
	}

	public boolean enregistreLancer(int nombreDeQuillesAbattues) {
		if (lancerActuel == 3) {
			return false;
		}
		lancers[lancerActuel++] = nombreDeQuillesAbattues;
		return lancerActuel < 2 || nombreDeQuillesAbattues == 10;
	}

	public boolean estTerminee() {
		return lancerActuel == 2 || (lancerActuel == 1 && lancers[0] == 10);
	}

	public int score() {
		return lancers[0] + lancers[1] + (lancerActuel == 3 ? lancers[2] : 0);
	}

	public int numeroProchainLancer() {
		if (lancerActuel == 2 && lancers[0] == 10) {
			return 1;
		}
		return lancerActuel + 1;
	}
}
