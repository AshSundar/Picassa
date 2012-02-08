package expression;

import java.util.ArrayList;

public abstract class OperandExpression extends Expression{

	protected ArrayList <Expression> input = null;	
	
	protected OperandExpression (ArrayList<Expression> operand) {
		input = new ArrayList<Expression>();
		input.addAll(operand); 
	}
}
