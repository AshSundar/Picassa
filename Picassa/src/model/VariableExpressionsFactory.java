package model;

import java.util.regex.Pattern;


public abstract class VariableExpressionsFactory extends ConstantVariableExpressionsFactory {

    public static final Pattern VARIABLE_REGEX =
    		Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
    protected final Pattern getMatcher (){
		return VARIABLE_REGEX;
    	
    }
}
