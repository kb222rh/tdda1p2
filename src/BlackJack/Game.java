package BlackJack;

import java.io.PrintStream;

public class Game {
	PrintStream out;
	public final String MENU="(s)tand, (h)it, (q)uit";
	public Game(PrintStream o) {
		this.out=o;
	}
	public void showMenu() {
		this.out.println(MENU);
	}

}
