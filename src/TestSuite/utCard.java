package TestSuite;

//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

//import java.util.List;

import org.junit.Test;

import BlackJack.Card;

public class utCard {
	// syntax
	// List mockedList= mock(List.class); 
	@Test (expected=IllegalArgumentException.class)
	public void Card_ConstructorWithNull_ThrowsIllegalArgumentException() throws IllegalArgumentException {
		new Card(null, null);
	}

}
