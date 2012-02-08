package expression;

import java.util.ArrayList;
import java.util.HashMap;

  
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class CeilingExpression extends OperandExpression{

	protected CeilingExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor( Math.ceil(input.get(0).evaluate(variableMap).getRed()), 
				Math.ceil(input.get(0).evaluate(variableMap).getGreen()),
				Math.ceil(input.get(0).evaluate(variableMap).getBlue()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "ceil");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new CeilingExpression (parseOperandExpression (pInput, 1));
		}
	}
}