package BlackJack;



public class Card {

	public Card.color c;
	public Card.value v;

	public enum color{ 
		Spades, Hearts, Clubs, Diamonds
	}



	public enum value {
		Ace, King, Queen, Knight, ten, nine, eight, seven, six, five, four, three, two
	}

	public Card(Card.value cV, Card.color cC) {
		if (cV==null||cC==null)
			throw new IllegalArgumentException();
		v=cV;
		c=cC;
	}

}
