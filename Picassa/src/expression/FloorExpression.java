package expression;

import java.util.ArrayList;
import java.util.HashMap;

 
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class FloorExpression extends OperandExpression{

	protected FloorExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.floor(input.get(0).evaluate(variableMap).getRed()),
				Math.floor(input.get(0).evaluate(variableMap).getGreen()),
				Math.floor(input.get(0).evaluate(variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "floor");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new FloorExpression(parseOperandExpression (pInput, 1));
		}
	}
}
