package BlackJack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;


public class KeyInput {
	BufferedReader inTo;
	PrintStream outTo;
	public KeyInput(BufferedReader m_in, PrintStream p){
		this.inTo=m_in;
		this.outTo=p;
	}
	public boolean read() throws IOException {
		// TODO Auto-generated method stub
		return inTo.readLine()=="q";
	}
}
