package expression;

import java.util.ArrayList;
import java.util.HashMap;

  
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class ClampExpression extends OperandExpression{

	protected ClampExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		input.get(0).evaluate(variableMap).clamp();
		return (input.get(0).evaluate(variableMap));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory( ) {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "clamp");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new ClampExpression (parseOperandExpression (pInput, 1));
		}
	}
}
