package expression;

import java.util.ArrayList;
import java.util.HashMap;

 
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class AbsoluteExpression extends OperandExpression{

	protected AbsoluteExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return new RGBColor(Math.abs(input.get(0).evaluate(variableMap).getRed()), 
				Math.abs(input.get(0).evaluate(variableMap).getGreen()), Math.abs(input.get(0).evaluate(variableMap).getBlue()) ) ;
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory( ) {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "abs");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new AbsoluteExpression(parseOperandExpression (pInput, 1));
		}
	}
}