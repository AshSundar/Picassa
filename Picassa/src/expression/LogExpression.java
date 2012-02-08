package expression;

import java.util.ArrayList;
import java.util.HashMap;

 
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class LogExpression extends OperandExpression{

	protected LogExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor (Math.log(input.get(0).evaluate(variableMap).getRed()), Math.log(input.get(0).evaluate(variableMap).getBlue()),
				Math.log(input.get(0).evaluate(variableMap).getGreen()));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "log");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new LogExpression(parseOperandExpression (pInput, 1));
		}
	}
}