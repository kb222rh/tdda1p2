package TestSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import BlackJack.Card;
import BlackJack.Card.color;
import BlackJack.Card.value;

public class utCard {
	@Test (expected=IllegalArgumentException.class)
	public void Card_ConstructorWithNull_ThrowsIllegalArgumentException() throws IllegalArgumentException {
		new Card(null, null);
	}

	@Test
	public void Card_Constructor_canCreateAceOfSpades(){
		try{
			new Card(value.Ace, color.Spades);
		} catch(Exception e) {
			fail();
		}
	}

//This was abit tricky. I check if there are 4 values in color Enum, and then check that their names are compliant with traditional card suites
// 
	@Test
	public void Card_Constructor_4ColorsExist(){
		for (color c : color.values()){
			assertTrue(color.values().length==4);
			assertTrue(c.name().equals("Spades")||c.name().equals("Hearts")||c.name().equals("Clubs")||c.name().equals("Diamonds"));
		}
	}
}
