package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class CosineExpression extends OperandExpression{

	protected CosineExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.cos(input.get(0).evaluate(variableMap).getRed()), Math.cos(input.get(0).evaluate(variableMap).getGreen()),
				Math.cos(input.get(0).evaluate(variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super ();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return  kindOfExpression(pInput, "cos");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new CosineExpression (parseOperandExpression (pInput, 1));
		}
	}
}