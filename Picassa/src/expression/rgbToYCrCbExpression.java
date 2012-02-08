package expression;

import java.util.ArrayList;
import java.util.HashMap;

  
import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;
import model.util.ColorModel;

public class rgbToYCrCbExpression extends OperandExpression{

	protected rgbToYCrCbExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return ColorModel.rgb2ycrcb(input.get(0).evaluate(variableMap));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super( );
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "rgbToYCrCb");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new rgbToYCrCbExpression(parseOperandExpression (pInput, 1));
		}
	}
}
