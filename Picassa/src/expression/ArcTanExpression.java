package expression;

import java.util.ArrayList;
import java.util.HashMap;

 
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class ArcTanExpression extends OperandExpression{

	protected ArcTanExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.atan(input.get(0).evaluate(variableMap).getRed()),
				Math.atan(input.get(0).evaluate(variableMap).getGreen()), Math.atan(input.get(0).evaluate(variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super ();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "atan");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new ArcTanExpression (parseOperandExpression (pInput, 1));
		}
	}
}