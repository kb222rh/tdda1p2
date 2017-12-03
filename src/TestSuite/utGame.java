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
	@Test
	public void Game_showCards_PrintsPlayerHand() throws IOException{
		Card c1=Mockito.mock(Card.class);
		Card c2=Mockito.mock(Card.class);
		Mockito.when(c1.getFace()).thenReturn("Ace of Base");
		Mockito.when(c2.getFace()).thenReturn("Test of Prints");
		ArrayList<Card> a=new ArrayList<Card>();
		a.add(c1);
		a.add(c2);
		Mockito.when(m_player.showHand()).thenReturn(a);

		g.showCards(m_player);
		for (Card c : a){
			String expected=c.getFace();
			Mockito.verify(m_out).println(expected);
		}
	}
	@Test
	public void Game_run_invokeShuffleOnDeck() throws IOException{
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_deck, Mockito.times(1)).shuffle();
	}
	@Test
	public void Game_run_invokesShowHandforPlayerAndDealer() throws IOException{
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_player, Mockito.times(1)).showHand();
		Mockito.verify(m_dealer, Mockito.times(1)).showHand();
	}
	@Test
	public void Game_run_invokesCalcScoreforPlayerAndDealer() throws IOException{
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_player, Mockito.times(1)).calcScore();
		Mockito.verify(m_dealer, Mockito.times(1)).calcScore();
	}
	@Test
	public void Game_run_printsMenuAndDealsPlayerACardOnHitSignal() throws IOException{
		String expected = g.MENU;
		Mockito.when(m_in.hitSignal()).thenReturn(true).thenReturn(false);
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_out, Mockito.times(2)).println(expected);
		Mockito.verify(m_player, Mockito.times(3)).getCard(m_deck);
	}
	@Test
	public void Game_over_trueAbove21(){
		Mockito.when(m_player.calcScore()).thenReturn(22);
		assertTrue(g.over(m_player));
	}
	//redundant green
	@Test
	public void Game_over_falseBelow21(){
		Mockito.when(m_player.calcScore()).thenReturn(19);
		assertFalse(g.over(m_player));
	}
	@Test
	public void Game_run_StandSignalDealerDrawsCardsTo17OrEqual() throws IOException{
		Mockito.when(m_in.standSignal()).thenReturn(true).thenReturn(false);
		Mockito.when(m_in.quitSignal()).thenReturn(true);
		Mockito.when(m_dealer.calcScore()).thenReturn(16,16,18);
		g.run(m_player, m_dealer, m_deck);
		Mockito.verify(m_dealer, Mockito.atLeast(3)).getCard(m_deck);
	}
	@Test
	public void Game_isWinner_PrintsDealerWinnerIfDealerHandBeatsPlayer(){
		Mockito.when(m_dealer.calcScore()).thenReturn(21);
		Mockito.when(m_player.calcScore()).thenReturn(20);
		String expected="Dealer wins!";
		g.isWinner(m_player, m_dealer);
		Mockito.verify(m_out).println(expected);
	}
	@Test
	public void Game_isWinner_PrintsPlayerWinnerIfDealerHandWorseThenPlayerHand(){
		Mockito.when(m_dealer.calcScore()).thenReturn(20);
		Mockito.when(m_player.calcScore()).thenReturn(21);
		String expected="Player wins!";
		g.isWinner(m_player, m_dealer);
		Mockito.verify(m_out).println(expected);
	}
}

