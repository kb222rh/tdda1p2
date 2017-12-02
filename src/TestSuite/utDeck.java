package TestSuite;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import BlackJack.Card;
import BlackJack.Deck;
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
}

