package TestSuite;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import BlackJack.Game;
import BlackJack.KeyInput;

public class utKeyInput {
	BufferedReader m_in;
	PrintStream m_out;
	Game m_g;
	KeyInput k;

	@Before
	public void setUp() throws Exception {
		m_in = Mockito.mock(BufferedReader.class);
		m_out=Mockito.mock(PrintStream.class);
		m_g=Mockito.mock(Game.class);
		k=new KeyInput(m_in, m_out);
	}

	@Test
	public void keyInput_read_sendsQuitCommandOnQ() throws IOException {
		Mockito.when(m_in.readLine()).thenReturn("q");
		assertTrue(k.quitSignal());
	}
	@Test
	public void keyInput_read_sendsHitCommandOnH() throws IOException {
		Mockito.when(m_in.readLine()).thenReturn("h");
		assertTrue(k.hitSignal());
	}
	@Test
	public void keyInput_read_sendsStandCommandOnS() throws IOException {
		Mockito.when(m_in.readLine()).thenReturn("s");
		assertTrue(k.standSignal());
	}
}
