package BlackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import BlackJack.Card.NAMES;
import BlackJack.Card.SUITES;

public class Deck {
	private List<Card> stack= new ArrayList<Card>(); 
	public Deck(){
		for (SUITES c : SUITES.values()){
			for (NAMES v : NAMES.values()){
			stack.add(new Card(v, c));	
			}
			}
	}
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

	public Card drawCard() {
		// TODO Auto-generated method stub
		return stack.get(0);
	}
	
}
