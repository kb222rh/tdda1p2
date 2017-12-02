package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class KeyInput {
	BufferedReader inTo;
	PrintStream outTo;
	String saved;
	public KeyInput(BufferedReader m_in, PrintStream p){
		this.inTo=m_in;
		this.outTo=p;
	}

	public boolean quitSignal() throws IOException{
		return read()=="q";
	}

	public boolean hitSignal() throws IOException {
		// TODO Auto-generated method stub
		return read()=="h";
	}
	public String read() throws IOException {
	String s=inTo.readLine();
		return s;
	}

	public boolean standSignal() {
		// TODO Auto-generated method stub
		return false;
	}
}
