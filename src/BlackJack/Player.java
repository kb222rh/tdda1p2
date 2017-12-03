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
		int sum=0;
		int aceCount=0;
		for (Card c : hand){
			if (c.getValue()==11){
				aceCount++;
			}
			sum+=c.getValue();
			while (sum>21&&aceCount>0){
				sum-=10;
				aceCount--;
			}
		}
		return sum;
	}

}
