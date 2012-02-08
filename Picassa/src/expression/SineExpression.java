package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class SineExpression extends OperandExpression{

	protected SineExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate( HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.sin(input.get(0).evaluate( variableMap).getRed()), Math.sin(input.get(0).evaluate( variableMap).getGreen()),
				Math.sin(input.get(0).evaluate( variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return  kindOfExpression(pInput, "sin");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new SineExpression (parseOperandExpression (pInput, 1));
		}
	}
}