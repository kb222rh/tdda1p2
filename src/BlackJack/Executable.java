package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Game g= new Game(System.out, new KeyInput(new BufferedReader(new InputStreamReader(System.in))));
		g.run();
	}

}
