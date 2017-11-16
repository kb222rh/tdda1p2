package TestSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;

public class utCard {
	@Test (expected=IllegalArgumentException.class)
	public void Card_ConstructorWithNull_ThrowsIllegalArgumentException() throws IllegalArgumentException {
		new Card(null, null);
	}

	@Test
	public void Card_Constructor_canCreateAceOfSpades(){
		try{
		new Card(Card.value.Ace, Card.color.Spades);
		} catch(Exception e) {
			fail();
		}
	}
}
