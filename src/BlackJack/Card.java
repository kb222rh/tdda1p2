package BlackJack;



public class Card {

	public Card.SUITES c;
	public Card.NAMES v;

	public enum SUITES{ 
		Spades, Hearts, Clubs, Diamonds
	}



	public enum NAMES {
		Ace, King, Queen, Knight, ten, nine, eight, seven, six, five, four, three, two
	}
	

	public Card(Card.NAMES cV, Card.SUITES cC) {
		if (cV==null||cC==null)
			throw new IllegalArgumentException();
		v=cV;
		c=cC;
	}

}
