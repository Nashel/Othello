import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	MockTablero mockTablero = new MockTablero();
	Game game = new Game();
	
	@Test
	public void hacerJugadaTest() {
		
		game.setTablero(mockTablero);
		assertEquals(true,game.hacerJugada("C5"));
		assertEquals(true,game.hacerJugada("E6"));
		assertEquals(false,game.hacerJugada("fdgfd"));
		assertEquals(false,game.hacerJugada("6E"));
		assertEquals(false,game.hacerJugada(".."));
		assertEquals(false,game.hacerJugada("\n\n"));
		assertEquals(false,game.hacerJugada("++"));
	}
	
}
