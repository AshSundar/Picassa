package expression;

import java.util.ArrayList;
import java.util.HashMap;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;
import model.util.ColorModel;

public class yCrCbtoRBGExpression extends OperandExpression{

	protected yCrCbtoRBGExpression(ArrayList<Expression> operand) {
		super(operand);
	}

	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return ColorModel.ycrcb2rgb (input.get(0).evaluate( variableMap));
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory( ) {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "yCrCbtoRGB");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new yCrCbtoRBGExpression(parseOperandExpression (pInput, 1));
		}
	}
}

 