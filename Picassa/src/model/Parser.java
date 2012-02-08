package model;

import java.util.ArrayList;
import java.util.List;

import expression.AbsoluteExpression;
import expression.ArcTanExpression;
import expression.CeilingExpression;
import expression.ClampExpression;
import expression.ColorExpression;
import expression.ConstantExpression;
import expression.CosineExpression;
import expression.DividedExpression;
import expression.ExponentExpression;
import expression.Expression;
import expression.FloorExpression;
import expression.LetExpression;
import expression.LogExpression;
import expression.MinusExpression;
import expression.ModulusExpression;
import expression.NegationExpression;
import expression.ParserException;
import expression.PerlinBWExpression;
import expression.PerlinColorExpression;
import expression.PlusExpression;
import expression.MultiplyExpression;
import expression.RandomExpression;
import expression.SineExpression;
import expression.TangentExpression;
import expression.WrapExpression;
import expression.rgbToYCrCbExpression;
import expression.yCrCbtoRBGExpression;
import expression.VariableExpression;

/**
 * Parses a string into an expression tree based on rules for arithmetic.
 * 
 * Due to the nature of the language being parsed, a recursive descent parser 
 * is used 
 *   http://en.wikipedia.org/wiki/Recursive_descent_parser
 *   
 * @author former student solution
 * @author Robert C. Duvall (added comments, exceptions, some functions)
 */
public class Parser
{

	private ParserInput pInput; 
    private List<ExpressionsFactory> expKinds = new ArrayList<ExpressionsFactory>();
    
    
    public Parser() {
        expKinds.add(new PlusExpression.Factory());
        expKinds.add(new MinusExpression.Factory());
        expKinds.add(new MultiplyExpression.Factory());
        expKinds.add(new DividedExpression.Factory());
        expKinds.add(new NegationExpression.Factory());
        expKinds.add(new ExponentExpression.Factory());
        expKinds.add(new ModulusExpression.Factory());
        expKinds.add(new ColorExpression.Factory());        
        expKinds.add(new ConstantExpression.Factory());
        expKinds.add(new VariableExpression.Factory());
        expKinds.add(new LetExpression.Factory());        
        expKinds.add(new RandomExpression.Factory());
        expKinds.add(new AbsoluteExpression.Factory());
        expKinds.add(new ArcTanExpression.Factory());
        expKinds.add(new CeilingExpression.Factory());
        expKinds.add(new CosineExpression.Factory());
        expKinds.add(new FloorExpression.Factory());
        expKinds.add(new LogExpression.Factory());
        expKinds.add(new PerlinBWExpression.Factory());
        expKinds.add(new PerlinColorExpression.Factory());
        expKinds.add(new rgbToYCrCbExpression.Factory());
        expKinds.add(new SineExpression.Factory());
        expKinds.add(new TangentExpression.Factory());
        expKinds.add(new yCrCbtoRBGExpression.Factory());
        expKinds.add(new WrapExpression.Factory());
        expKinds.add(new ClampExpression.Factory());
        
    }
    
        
    /**
     * Converts given string into expression tree.
     * 
     * @param input expression given in the language to be parsed
     * @return expression tree representing the given formula
     */
    public Expression makeExpression (String input)
    {
    	pInput = new ParserInput();
        pInput.expKinds = expKinds; pInput.myInput = input; pInput.myCurrentPosition = 0;  
    	
        Expression result = ExpressionsFactory.parseExpression(pInput, pInput.expKinds);
        pInput.skipWhiteSpace();
        if (pInput.notAtEndOfString())
        {
            throw new ParserException("Unexpected characters at end of the string: " +
                                      pInput.myInput.substring(pInput.myCurrentPosition),
                                      ParserException.Type.EXTRA_CHARACTERS);
        }
        return result;
    }
}
