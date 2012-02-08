package model;

import java.util.regex.Matcher;


public abstract class ConstantVariableExpressionsFactory extends ExpressionsFactory{
	
	public boolean kindOfExpression (ParserInput pInput, String command){
		pInput.skipWhiteSpace();
		Matcher expMatcher =
				getMatcher().matcher(pInput.myInput.substring(pInput.myCurrentPosition));

		return expMatcher.lookingAt();
	}
	
	public String parseOtherExpression(ParserInput pInput) {
		pInput.skipWhiteSpace();
        Matcher doubleMatcher = getMatcher().matcher(pInput.myInput);
        doubleMatcher.find(pInput.myCurrentPosition);
        String stringMatch = 
            pInput.myInput.substring(doubleMatcher.start(), doubleMatcher.end());
        pInput.myCurrentPosition = doubleMatcher.end();
        
        return stringMatch;
	}
}
