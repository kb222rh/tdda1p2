package TestSuite;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import BlackJack.Card;
import BlackJack.Card.SUITES;
import BlackJack.Card.NAMES;

public class utCard {
	@Test (expected=IllegalArgumentException.class)
	public void Card_ConstructorWithNull_ThrowsIllegalArgumentException() throws IllegalArgumentException {
		new Card(null, null);
	}

	@Test
	public void Card_Constructor_canCreateAceOfSpades(){
		try{
			new Card(NAMES.Ace, SUITES.Spades);
		} catch(Exception e) {
			fail();
		}
	}

//This was abit tricky. I check if there are 4 values in color Enum, and then check that their names are compliant with traditional card suites
// 
	@Test
	public void Card_Constructor_4ColorsExist(){
		for (SUITES c : SUITES.values()){
			assertTrue(SUITES.values().length==4);
			assertTrue(c.name().equals("Spades")||c.name().equals("Hearts")||c.name().equals("Clubs")||c.name().equals("Diamonds"));
		}
	}
	@Test
	public void Card_Constructor_allCardValuesExist(){
		for (NAMES c : NAMES.values()){
			assertTrue(NAMES.values().length==13);
			assertTrue(c.name().equals("Ace")||c.name().equals("King")||c.name().equals("Queen")||c.name().equals("Knight")||c.name().equals("ten")||c.name().equals("nine")||c.name().equals("eight")||c.name().equals("seven")||c.name().equals("six")||c.name().equals("five")||c.name().equals("four")||c.name().equals("three")||c.name().equals("two"));
		}
	}
	
	//This is technically redundant, since it is green.
	@Test
	public void Card_Constructor_AllCardsCreationTest(){
		for (SUITES c : SUITES.values()){
			for (NAMES v : NAMES.values()){
				try{
					new Card(v, c);
				} catch(Exception e) {
					fail();
				}
			}
		}
	}
	@Test
	public void Card_getValue_AceOfSpadesReturnsEleven(){
		int expected = 11;
		Card actual= new Card(Card.NAMES.Ace, Card.SUITES.Spades);	
		assertEquals(actual.getValue(), expected);		
	}
}
