package expression;


import java.util.HashMap;

import model.ConstantExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

 
public class ConstantExpression extends Expression{
	double num = 0;
	
	public ConstantExpression (double position) {
		num = position;
 	}

	
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
    		return new RGBColor (num);
	}
	
    public static class Factory extends ConstantExpressionsFactory {
    	public Factory() {
    		super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
    		return kindOfExpression(pInput, null);

    	}
    	
    	public Expression parseExpression(ParserInput pInput) {
    		String stringMatch = parseOtherExpression (pInput);
	        double value = Double.parseDouble(stringMatch);
	        return new ConstantExpression (value);
    	}
    }

}