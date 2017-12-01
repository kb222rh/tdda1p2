package BlackJack;
public class Card {

	public Card.SUITES c;
	public Card.NAMES v;

	public enum SUITES{ 
		Spades("♠"), Hearts("♥"), Clubs("♦"), Diamonds("♣");
		public final String symbol;
		private SUITES(String s){
			this.symbol=s;
		}
	}

	public enum NAMES {
		Ace("A", 11), King("K", 10), Queen("Q", 10), Knight("Kn", 10), ten("10", 10), nine("9", 9), eight("8", 8), seven("7", 7), six("6", 6), five("5", 5), four("4", 4), three("3", 3), two("2", 2);
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
		return v.face+c.symbol;
	}
}
