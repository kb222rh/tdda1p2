package BlackJack;
public class Card {

	public Card.SUITES c;
	public Card.NAMES v;

	public enum SUITES{ 
		Spades("Spades"), Hearts("Hearts"), Clubs("Clubs"), Diamonds("Diamonds");
		public final String symbol;
		private SUITES(String s){
			this.symbol=s;
		}
	}

	public enum NAMES {
		Ace("Ace", 11), King("King", 10), Queen("Queen", 10), Knight("Knight", 10), Ten("Ten", 10), Nine("Nine", 9), Eight("Eight", 8), Seven("Seven", 7), Six("Six", 6), Five("Five", 5), Four("Four", 4), Three("Three", 3), Two("Two", 2);
		public final String face;
		public final int value;
		private NAMES(String f, int v){
			this.face=f;
			this.value=v;
		}
	}

	public Card(Card.NAMES cV, Card.SUITES cC) {
		if (cV==null||cC==null)
			throw new IllegalArgumentException();
		v=cV;
		c=cC;
	}

	public int getValue() {
		return v.value;
	}

	public String getFace() {
		return v.face+" of "+c.symbol;
	}
	public boolean equals(Card o){
		return this.getFace().equals(o.getFace());
	}
}
