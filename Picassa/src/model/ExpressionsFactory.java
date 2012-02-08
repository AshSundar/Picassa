package model;

import java.util.List;
import java.util.regex.Pattern;

import expression.Expression;
import expression.ParserException;

import model.ParserInput;

public abstract class ExpressionsFactory {
	public abstract boolean isThisKindOfExpression(ParserInput pInput );
	public abstract Expression parseExpression(ParserInput pInput );	
	protected abstract Pattern getMatcher(); 
	
	public static Expression parseExpression (ParserInput pInput, List <ExpressionsFactory> expKinds)
    {
        for(ExpressionsFactory expKind : expKinds) {
            if(expKind.isThisKindOfExpression(pInput)) {
                return expKind.parseExpression(pInput);
            }
        }
        throw new ParserException("Unrecognized command");
    }
}