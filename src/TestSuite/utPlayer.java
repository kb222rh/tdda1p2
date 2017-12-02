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
	private Card cardStub(String face){
		Card stub=Mockito.mock(Card.class);
		Mockito.when(stub.getFace()).thenReturn(face);
		return stub;
	}
	private Deck deckStub(Card c){
		Deck stub=Mockito.mock(Deck.class);
		Mockito.when(stub.drawCard()).thenReturn(c);
		return stub;
	}
	@Before
	public void setUp() throws Exception {
		p=new Player();
	}

	@Test
	public void Player_getCard_DrawsCardFromDeck() {
		Deck mock=deckStub(cardStub("Ace of Shovels"));
		Card actual= p.getCard(mock);
		assertEquals(mock.drawCard(), actual);
	}
	@Test
	public void Player_showHand_ReturnsCardsDrawnAsArrayList(){
		Card c1=cardStub("Ace of Lollipops");
		Card c2=cardStub("Ace of bananas");
		Deck m1=deckStub(c1);
		Deck m2=deckStub(c2);
		p.getCard(m1);
		p.getCard(m2);
		ArrayList<Card> actual= p.showHand();

		assertEquals(c1, actual.get(0));
		assertEquals(c2, actual.get(1));
	}
}
