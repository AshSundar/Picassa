package expression;
import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;
import model.util.PerlinNoise;

public class PerlinBWExpression extends OperandExpression{

	protected PerlinBWExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return PerlinNoise.greyNoise(input.get(0).evaluate(variableMap), input.get(1).evaluate(variableMap));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
 		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "perlinBW");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new PerlinBWExpression(parseOperandExpression (pInput, 2));
		}
	}
}