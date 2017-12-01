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
	@Test
	public void Card_Constructor_allCardValuesExist(){
		for (value c : value.values()){
			assertTrue(value.values().length==13);
			assertTrue(c.name().equals("Ace")||c.name().equals("King")||c.name().equals("Queen")||c.name().equals("Knight")||c.name().equals("ten")||c.name().equals("nine")||c.name().equals("eight")||c.name().equals("seven")||c.name().equals("six")||c.name().equals("five")||c.name().equals("four")||c.name().equals("three")||c.name().equals("two"));
		}
	}
}
