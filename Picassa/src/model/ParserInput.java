package model;

import java.util.List;



public class ParserInput {
	// state of the parser
	protected int myCurrentPosition;
	protected String myInput; 
	protected List <ExpressionsFactory> expKinds; 
	
	public void skipWhiteSpace ()
	{
		while (notAtEndOfString() && 
				Character.isWhitespace(currentCharacter()))
		{
			++myCurrentPosition;
		}
	}

	public char currentCharacter ()
	{
		return myInput.charAt(myCurrentPosition);
	}

	public boolean notAtEndOfString ()
	{
		return myCurrentPosition < myInput.length();
	}
}
