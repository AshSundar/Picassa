package model;

import java.util.regex.Pattern;


public abstract class ConstantExpressionsFactory extends ConstantVariableExpressionsFactory {

	public static final Pattern DOUBLE_REGEX =
			Pattern.compile("(\\-?[0-9]+(\\.[0-9]+)?)|(\\-?.[0-9]+)");
	
    protected final Pattern getMatcher (){
		return DOUBLE_REGEX;
    	
    }

}
