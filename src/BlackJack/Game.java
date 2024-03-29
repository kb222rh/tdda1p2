package BlackJack;

import java.io.IOException;
import java.io.PrintStream;

public class Game {
	PrintStream out;
	KeyInput input;
	public final String MENU="(s)tand, (h)it, (q)uit";
	public final String DWIN="Dealer wins!";
	public final String PWIN="Player wins!";
	public Game(PrintStream o, KeyInput k) {
		this.out=o;
		this.input=k;
	}
	public void showMenu() {
		this.out.println(MENU);
	}

	public void run(Player player, Player dealer, Deck deck) throws IOException {
		boolean play=true;
		deck.shuffle();
		player.getCard(deck);
		dealer.getCard(deck);
		player.getCard(deck);
		dealer.getCard(deck);

		while (play){
			displayStatus(player, dealer);	
			this.showMenu();
			input.read();
			
			if(input.standSignal()){
				while(dealer.calcScore()<18)
					dealer.getCard(deck);
				play=false;
				displayStatus(player, dealer);
				isWinner(player,dealer);
			} else if (input.hitSignal()&&!over(player)){
				player.getCard(deck);
			} else if (input.quitSignal()){
				play=false;
			}
		}
	}

	public void showCards(Player p) {
		for (Card c: p.showHand()){
			this.out.println(c.getFace());
		}
		this.out.println("------------");
	}
	public boolean over(Player p) {
		return p.calcScore()>21;
	}
	public void isWinner(Player p, Player d){
		if (d.calcScore()>=p.calcScore()&&!over(d)||over(p))
		this.out.println(DWIN);
		else 
		this.out.println(PWIN);
	}
	
	private void displayStatus(Player player, Player dealer){
		this.out.println("Dealer: "+dealer.calcScore());
		showCards(dealer);

		this.out.println("Player: "+player.calcScore());
		showCards(player);
	}
}
