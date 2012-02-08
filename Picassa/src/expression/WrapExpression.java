package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class WrapExpression extends OperandExpression{

	protected WrapExpression (ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		input.get(0).evaluate(variableMap).wrap();
		return (input.get(0).evaluate(variableMap));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "wrap");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new WrapExpression (parseOperandExpression (pInput, 1));
		}
	}
}
