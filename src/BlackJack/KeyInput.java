package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;



public class KeyInput {
	BufferedReader inTo;
	String saved;
	public KeyInput(BufferedReader m_in){
		this.inTo=m_in;
	}

	public boolean quitSignal() throws IOException{
		return saved.equals("q");
	}

	public boolean hitSignal() throws IOException {
		return saved.equals("h");
	}
	
	public boolean standSignal() throws IOException {
		return saved.equals("s");
	}
	
	public void read() throws IOException {
		saved=inTo.readLine();
		
	}

}
