package expression;

import java.util.ArrayList;
import java.util.HashMap;

import expression.Expression;
   
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class LetExpression extends OperandExpression{

	protected LetExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		HashMap<String, RGBColor> tempMap = new HashMap<String, RGBColor>();
		tempMap.putAll(variableMap);

		VariableExpression tempVarExp = (VariableExpression)input.get(0);
		tempMap.put(tempVarExp.getVar(), input.get(1).evaluate(tempMap));
			
		RGBColor tempColor = input.get(2).evaluate(tempMap);

		tempMap.remove(tempVarExp.getVar());
		
		return (tempColor);
		 
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "let");
		}

		public Expression parseExpression(ParserInput pInput) { 
			ArrayList<Expression> tempList = (parseOperandExpression (pInput, 3));
			
			if (!(tempList.get(0) instanceof VariableExpression))
				throw new ParserException("1st operand of Let must be a variable");
			
			return new LetExpression (tempList);

		}
	}
}