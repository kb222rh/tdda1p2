package TestSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;
import BlackJack.Deck;
public class utDeck {

	@Test
	public void Deck_constructor_has52Cards() {
		Deck sut=new Deck();
		assertTrue(sut.size()==52);
		for (int i=0; i<sut.size(); i++)
        assertTrue(sut.drawCard() instanceof Card);
	}
	@Test
	public void Deck_equals_ReturnsTrueForNewDecks(){
		Deck a=new Deck();
		Deck b=new Deck();
		assertTrue(a.equals(b));
	}
}

