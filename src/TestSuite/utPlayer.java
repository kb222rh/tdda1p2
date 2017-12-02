package TestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.Player;

public class utPlayer {
Player p;
	@Before
	public void setUp() throws Exception {
		p=new Player();
	}

	@Test
	public void Player_getCard_DrawsCardFromDeck() {
		Deck deckStub=Mockito.mock(Deck.class);
		Card cardStub=Mockito.mock(Card.class);
		Card actual= p.getCard(deckStub);
		Mockito.when(deckStub.drawCard()).thenReturn(cardStub);
		Mockito.when(cardStub.getFace()).thenReturn("Ace of Spades");
		assertEquals(deckStub.drawCard(), actual);
		
	}

}
