package expression;

import java.util.ArrayList;
import java.util.HashMap;
 
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

  
public class MultiplyExpression extends OperandExpression{
	
	public MultiplyExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	public RGBColor evaluate (HashMap<String, RGBColor> variableMap)
    {
    	return new RGBColor (input.get(0).evaluate(variableMap).getRed() * input.get(1).evaluate(variableMap).getRed(), 
    			input.get(0).evaluate(variableMap).getGreen() * input.get(1).evaluate(variableMap).getGreen(),
    			input.get(0).evaluate(variableMap).getBlue() * input.get(1).evaluate(variableMap).getBlue());
    }
    
    public static class Factory extends OperandExpressionsFactory {
    	public Factory( ) {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
    		return kindOfExpression(pInput, "mul");
    	}
    	
    	public Expression parseExpression(ParserInput pInput) { 
            return new MultiplyExpression(parseOperandExpression (pInput, 2));
    	}
    }

}
