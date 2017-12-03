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
		return "q".equals(read());
	}

	public boolean hitSignal() throws IOException {
		return "h".equals(read());
	}
	
	public boolean standSignal() throws IOException {
		return "s".equals(read());
	}
	
	public String read() throws IOException {
		String s=inTo.readLine();
		return s;
	}

}
