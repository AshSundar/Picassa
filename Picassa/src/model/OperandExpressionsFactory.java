package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import expression.Expression;
import expression.ParserException;

import model.ParserInput;

public abstract class OperandExpressionsFactory extends ExpressionsFactory{
	public static final Pattern EXPRESSION_BEGIN_REGEX =
			Pattern.compile("\\(([a-zA-Z]+)");


	ParserInput pInput;
	public OperandExpressionsFactory() {
		super();
	}

	protected final Pattern getMatcher (){
		return EXPRESSION_BEGIN_REGEX;
	}

	public boolean kindOfExpression (ParserInput pInput, String command){
		pInput.skipWhiteSpace();
		Matcher expMatcher =
				getMatcher().matcher(pInput.myInput.substring(pInput.myCurrentPosition));
		if (expMatcher.lookingAt()) {
			String commandName = expMatcher.group(1);
			return commandName.equals(command);
		}
		else return false;
	}
	public ArrayList<Expression> parseOperandExpression(ParserInput pInput, int numParam) {
		pInput.skipWhiteSpace();
		Matcher expMatcher = getMatcher().matcher(pInput.myInput);
		expMatcher.find(pInput.myCurrentPosition);
		pInput.myCurrentPosition = expMatcher.end();

		pInput.skipWhiteSpace();
		ArrayList<Expression> param = new ArrayList<Expression>();

		for (int i = 0; i < numParam; i++)
			param.add(parseExpression(pInput, pInput.expKinds));//This recursion is used for nested expressions. I cannot move this away from ParserInput. 
		if (pInput.currentCharacter() == ')')
		{
			pInput.myCurrentPosition++;
			return param;
		}
		else
		{
			throw new ParserException("Expected close paren, instead found " +
					pInput.myInput.substring(pInput.myCurrentPosition));
		}
	}

}
