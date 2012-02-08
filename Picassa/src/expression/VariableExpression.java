package expression;

import java.util.HashMap;

import model.ParserInput;
import model.RGBColor;
import model.VariableExpressionsFactory;

public class VariableExpression extends Expression{

	String var = null;

	public VariableExpression (String position) {
		var = position;
	}
	
	public String getVar (){
		return var;
	}

	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		if (variableMap.containsKey(var))
			return new RGBColor (variableMap.get(var));
		else
			throw new ParserException("Unknown variable ");

	}

	public static class Factory extends VariableExpressionsFactory {
		public Factory() {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, null);
		}

		public Expression parseExpression(ParserInput pInput) {
			String stringMatch = parseOtherExpression (pInput);
	        return new VariableExpression (stringMatch);
		}
	}

}
