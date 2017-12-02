package TestSuite;
import static org.junit.Assert.*;
import org.junit.Test;
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
			assertTrue(c.name().equals("Ace")||c.name().equals("King")||c.name().equals("Queen")||c.name().equals("Knight")||c.name().equals("Ten")||c.name().equals("Nine")||c.name().equals("Eight")||c.name().equals("Seven")||c.name().equals("Six")||c.name().equals("Five")||c.name().equals("Four")||c.name().equals("Three")||c.name().equals("Two"));
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
		assertEquals(expected, actual.getValue());		
	}
	@Test
	public void Card_getValue_ReturnsCorrectValue(){
		for (SUITES c : SUITES.values()){
			for (NAMES v : NAMES.values()){
				try{
					Card sut = new Card(v, c);
					int expected = v.value;
					int actual=sut.getValue();
					assertEquals(expected, actual);

				} catch(Exception e) {
					fail();
				}
			}
		}	
	}
	@Test
	public void Card_getFace_ReturnsCorrectFace(){
		for (SUITES c : SUITES.values()){
			for (NAMES v : NAMES.values()){
				try{
					Card sut = new Card(v, c);
					String expected = v.face+" of "+c.symbol;
					String actual=sut.getFace();
					assertEquals(expected, actual);

				} catch(Exception e) {
					fail();
				}
			}
		}	
	}
	@Test
	public void Card_equals_ReturnsTrueIfFacesAreSame(){
		Card b=new Card(NAMES.Eight,SUITES.Diamonds);
		Card c=new Card(NAMES.Eight, SUITES.Diamonds);
		assertTrue(b.equals(c));
	}
	@Test
	public void Card_equals_ReturnsFalseIfFacesAreNotSame(){
		Card b=new Card(NAMES.Ace,SUITES.Clubs);
		Card c=new Card(NAMES.Eight, SUITES.Diamonds);
		assertFalse(b.equals(c));
	}
}
