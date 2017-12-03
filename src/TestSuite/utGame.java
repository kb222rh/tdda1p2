package TestSuite;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.Game;
import BlackJack.KeyInput;
import BlackJack.Player;

public class utGame {
	PrintStream m_out;
	Game g;
	KeyInput m_in;
	Player m_player;
	Player m_dealer;
	Deck m_deck;
	@Before
	public void setUp() throws Exception {
		m_out=Mockito.mock(PrintStream.class);
		m_in=Mockito.mock(KeyInput.class);
		g = new Game(m_out, m_in);
		m_player=Mockito.mock(Player.class);
		m_dealer=Mockito.mock(Player.class);
		m_deck=Mockito.mock(Deck.class);
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
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_out).println(expected);
	}
	@Test
		public void Game_run_deals2CardsToPlayerAndDealerEach() throws IOException{
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run(m_player, m_dealer, m_deck);	
		Mockito.verify(m_player, Mockito.times(2)).getCard(m_deck);
		Mockito.verify(m_dealer, Mockito.times(2)).getCard(m_deck);
	}
	
}

