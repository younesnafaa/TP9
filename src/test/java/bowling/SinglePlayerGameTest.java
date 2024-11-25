package bowling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SinglePlayerGameTest {

	private PartieMonoJoueur partie;

	@BeforeEach
	public void setUp() {
		partie = new PartieMonoJoueur();
	}

	@Test
	void testPerfectGame() {
		for (int i = 0; i < 12; i++) {
			assertFalse(partie.enregistreLancer(10));
		}
		assertEquals(300, partie.score());
	}

	@Test
	void testOneSpare() {
		assertFalse(partie.enregistreLancer(7));
		assertFalse(partie.enregistreLancer(3));
		assertFalse(partie.enregistreLancer(3));
		assertEquals(13, partie.score());
	}

	@Test
	void testOneStrike() {
		assertFalse(partie.enregistreLancer(10));
		assertFalse(partie.enregistreLancer(3));
		assertFalse(partie.enregistreLancer(4));
		assertEquals(24, partie.score());
	}

	@Test
	void deuxStrikes() {
		assertFalse(partie.enregistreLancer(10));
		assertFalse(partie.enregistreLancer(10));
		assertFalse(partie.enregistreLancer(3));
		assertFalse(partie.enregistreLancer(4));
		assertEquals(48, partie.score());
	}
}
