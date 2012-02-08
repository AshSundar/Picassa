package model;

import java.awt.Dimension;
import java.util.HashMap;

import expression.Expression;


/**
 * Evaluate an expression for each pixel in a image.
 * 
 * @author Robert C Duvall
 */
public class Model
{
    public static final double DOMAIN_MIN = -1;
    public static final double DOMAIN_MAX = 1;

    private HashMap<String, RGBColor> variableMap = new HashMap<String, RGBColor>();
    /**
     * Evaluate an expression for each point in the image.
     */
    public Pixmap evaluate (String input, Dimension size) //Supposed provide the correct colors for each specified pixel in the canvas
    {
        Pixmap result = new Pixmap(size);
        // create expression to evaluate just once
        Expression toEval = new Parser().makeExpression(input);
        // evaluate at each pixel
        for (int imageY = 0; imageY < size.height; imageY++)
        {
            double evalY = imageToDomainScale(imageY, size.height);
            for (int imageX = 0; imageX < size.width; imageX++)
            {
                double evalX = imageToDomainScale(imageX, size.width);
                variableMap.put("x", new RGBColor (evalX));
                variableMap.put("y", new RGBColor (evalY));

                result.setColor(imageX, imageY,
                                toEval.evaluate(variableMap).toJavaColor()); //Go to Expression
            }
        }
        return result;
    }


    /**
     * Convert from image space to domain space.
     */
    public double imageToDomainScale (int value, int bounds)
    {
        double range = DOMAIN_MAX - DOMAIN_MIN;
        return ((double)value / bounds) * range + DOMAIN_MIN;
    }
}
