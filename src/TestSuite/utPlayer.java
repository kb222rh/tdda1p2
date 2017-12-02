package TestSuite;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
		Mockito.when(deckStub.drawCard()).thenReturn(cardStub);
		Mockito.when(cardStub.getFace()).thenReturn("Ace of Spades");
		Card actual= p.getCard(deckStub);
		assertEquals(deckStub.drawCard(), actual);
	}
	@Test
	public void Player_showHand_ReturnsCardsDrawnAsArrayList(){
		Deck deckStub=Mockito.mock(Deck.class);
		Card cardStub1=Mockito.mock(Card.class);
		Card cardStub2=Mockito.mock(Card.class);
		Mockito.when(deckStub.drawCard()).thenReturn(cardStub1);
		Mockito.when(cardStub1.getFace()).thenReturn("Ace of Spades");
		p.getCard(deckStub);
		Mockito.when(deckStub.drawCard()).thenReturn(cardStub2);
		Mockito.when(cardStub2.getFace()).thenReturn("Ace of Clubs");
		p.getCard(deckStub);
		ArrayList<Card> actual= p.showHand();
		
		assertEquals(cardStub1, actual.get(0));
		assertEquals(cardStub2, actual.get(1));
	}
}
