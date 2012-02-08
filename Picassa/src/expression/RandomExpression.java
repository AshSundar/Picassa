package expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import model.OperandExpressionsFactory;
import model.ParserInput;
import model.RGBColor;

public class RandomExpression extends OperandExpression{
	protected RGBColor c = null; 
	
	protected RandomExpression(ArrayList<Expression> operand) {
		super(operand);
		c = random();
	}

	@Override
	public RGBColor evaluate(HashMap<String, RGBColor> variableMap) {
		return c;
	}

	public RGBColor random ()
	{
		Random rand = new Random(); 
		int redRand = rand.nextInt(2)-1; int greenRand = rand.nextInt(2)-1; int blueRand = rand.nextInt(2)-1;
		
		return new RGBColor(redRand, greenRand, blueRand);
	}

	public static class Factory extends OperandExpressionsFactory {
		public Factory() {
			super();
		}

		public boolean isThisKindOfExpression(ParserInput pInput) {
			return kindOfExpression(pInput, "random");
		}

		public Expression parseExpression(ParserInput pInput) { 
			return new RandomExpression (parseOperandExpression (pInput, 0));
		}
	}
}