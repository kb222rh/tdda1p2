package BlackJack;

import java.io.IOException;
import java.io.PrintStream;

public class Game {
	PrintStream out;
	KeyInput input;
	public final String MENU="(s)tand, (h)it, (q)uit";
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

		this.out.println("Dealer: ");
		showCards(dealer);
		this.out.println("------------");
		this.out.println("Player: ");
		showCards(player);
		this.out.println("------------");

		while (play){
			this.showMenu();
			if (input.quitSignal()==true){
				play=false;
			}
		}
	}

	public void showCards(Player p) {
		for (Card c: p.showHand()){
			this.out.println(c.getFace());
		}
	}

}
