package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

  
public class ExponentExpression extends OperandExpression{
	
	public ExponentExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	public RGBColor evaluate (HashMap<String, RGBColor> variableMap)
    {
    	return new RGBColor( Math.pow(input.get(0).evaluate(variableMap).getRed(), input.get(1).evaluate(variableMap).getRed()),
    			Math.pow(input.get(0).evaluate(variableMap).getBlue(), input.get(1).evaluate(variableMap).getBlue()),
    			Math.pow(input.get(0).evaluate(variableMap).getGreen(), input.get(1).evaluate(variableMap).getGreen())
    			);
    }

    public static class Factory extends OperandExpressionsFactory {
    	public Factory( ) {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
    		return kindOfExpression(pInput, "exp");
    	}
    	
    	public Expression parseExpression(ParserInput pInput) { 
            return new ExponentExpression(parseOperandExpression (pInput, 2));
    	}
    }

}
