package BlackJack;



public class Card {

	public Card.color c;
	public Card.value v;

	public enum color{ 
		Spades, Hearts, Clubs, Diamonds
	}



	public enum value {
		Ace
	}

	public Card(Card.value cV, Card.color cC) {
		if (cV==null||cC==null)
			throw new IllegalArgumentException();
		v=cV;
		c=cC;
	}

}
