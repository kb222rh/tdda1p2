package BlackJack;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> hand;
	public Player(){
		this.hand=new ArrayList<Card>();
	}

	public Card getCard(Deck d) {
		Card drawn=d.drawCard();
		hand.add(drawn);
		return drawn;
	}

	public ArrayList<Card> showHand() {
		return hand;
	}

	public int calcScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
