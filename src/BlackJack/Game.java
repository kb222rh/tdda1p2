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
		while (play){
			this.showMenu();
			if (input.quitSignal()==true){
				play=false;
			}
			
		}
	}
	
}
