package TestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Card;
import BlackJack.Deck;
import BlackJack.Card.NAMES;
import BlackJack.Card.SUITES;
public class utDeck {
	private Deck a;
	private Deck b;

	@Before
	public void setup(){
		a=new Deck();
		b=new Deck();
	}
	@Test
	public void Deck_constructor_has52Cards() {
		assertTrue(a.size()==52);
		for (int i=0; i<a.size(); i++)
			assertTrue(a.drawCard() instanceof Card);
	}
	@Test
	public void Deck_equals_ReturnsTrueForNewDecks(){
		assertTrue(a.equals(b));
	}
	@Test
	public void Deck_equals_ReturnsFalseAfterShuffle(){
		b.shuffle();
		assertFalse(a.equals(b));
	}
	//Redundant, green to begin with, apparently this chance is 1 in 10^68
	@Test
	public void TwoShuflledDecks_equals_ReturnsFalse(){
		for (int i=0; i<1000; i++){
		a.shuffle();
		b.shuffle();
		assertFalse(a.equals(b));
		}
	}
	@Test
	public void newDeck_drawCard_popsFirstCardFromDeck(){
		NAMES iName;
		SUITES iSuite;
		for (int j=0; j<4; j++){
			for (int i=0; i<13; i++){
				iName=NAMES.values()[i];
				iSuite=SUITES.values()[j];
				Deck expected=Mockito.mock(Deck.class);
				Card actual=a.drawCard();
				Mockito.when(expected.drawCard()).thenReturn(new Card(iName, iSuite));
				assertTrue(expected.drawCard().equals(actual));
			}
		}
	}
}

