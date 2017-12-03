package TestSuite;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Game;

public class uGame {
	PrintStream m_out;
	Game g;
	@Before
	public void setUp() throws Exception {
		m_out=Mockito.mock(PrintStream.class);
		g = new Game(m_out);
	}

	@Test
	public void Game_showMenu_printsMenu() {
		String expected = "(s)tand, (h)it, (q)uit";	
		g.showMenu();
		Mockito.verify(m_out).println(expected);
	}

}
