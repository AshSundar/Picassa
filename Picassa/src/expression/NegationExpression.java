package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

 
public class NegationExpression extends OperandExpression{
	
	public NegationExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	public RGBColor evaluate (HashMap<String, RGBColor> variableMap)
    {
    	return new RGBColor (input.get(0).evaluate(variableMap).getRed()* -1, input.get(0).evaluate(variableMap).getGreen()* -1, 
    			input.get(0).evaluate(variableMap).getBlue()* -1); 
    }
    
    public static class Factory extends OperandExpressionsFactory {
    	public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
    		return kindOfExpression (pInput, "neg");
    	}
    	
    	public Expression parseExpression(ParserInput pInput) { 
            return new NegationExpression( parseOperandExpression (pInput, 1));
    	}
    }

}
