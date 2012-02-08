package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class TangentExpression extends OperandExpression{

	protected TangentExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate( HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.tan(input.get(0).evaluate(variableMap).getRed()), Math.tan(input.get(0).evaluate(variableMap).getGreen()), 
				Math.tan(input.get(0).evaluate(variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "tan");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new TangentExpression(parseOperandExpression (pInput, 1));
		}
	}
}