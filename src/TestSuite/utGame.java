package TestSuite;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Game;
import BlackJack.KeyInput;

public class utGame {
	PrintStream m_out;
	Game g;
	KeyInput m_in;
	@Before
	public void setUp() throws Exception {
		m_out=Mockito.mock(PrintStream.class);
		m_in=Mockito.mock(KeyInput.class);
		g = new Game(m_out, m_in);
	}

	@Test
	public void Game_showMenu_printsMenu() {
		String expected = g.MENU;	
		g.showMenu();
		Mockito.verify(m_out).println(expected);
	}
	
	@Test
	public void Game_run_printsMenuAndQuitsOnQuitSignal() throws IOException{
		String expected = g.MENU;
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run();
		Mockito.verify(m_out).println(expected);
	}
	
}
