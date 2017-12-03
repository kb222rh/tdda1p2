package TestSuite;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.Player;
import BlackJack.Card.NAMES;

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
	@Test
	public void Player_calcScore_returnsSumOfCardValues(){
		int expectedSum=0;
		for (int i = 0; i<10; i++){
			Card c = cardStub("Ace of Random");
			Deck d= deckStub(c);
			Mockito.when(c.getValue()).thenReturn(i);
			p.getCard(d);
			expectedSum+=i;		
		}
		assertEquals(expectedSum, p.calcScore());
	}
	@Test
	public void Player_calcScore_accountsForAceInSoftHands(){
		Card cAce1 = Mockito.mock(Card.class);
		Mockito.when(cAce1.getValue()).thenReturn(11);
		Card cKn1 = Mockito.mock(Card.class);
		Mockito.when(cKn1.getValue()).thenReturn(10);
		Card cQ1 = Mockito.mock(Card.class);
		Mockito.when(cQ1.getValue()).thenReturn(10);
		Deck d1=deckStub(cAce1);
		p.getCard(d1);
		Deck d2=deckStub(cKn1);
		p.getCard(d2);
		Deck d3=deckStub(cQ1);
		p.getCard(d3);
		int expected = 21;
		int actual = p.calcScore();
		assertSame(actual, expected);
	}
}
