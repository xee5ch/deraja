package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public class Utilities {
	
	public static final BigDecimal FIVE = Utilities.toScaledValue(5.0f);
	
	public static final BigDecimal NINE = Utilities.toScaledValue(9.0f);
	
	public static BigDecimal toScaledValue(float f)
	{
		return new BigDecimal(String.format("%.2f", f));
	}
	
	public static String toScaledString(String s)
	{
		float f = Float.parseFloat(s);
		return String.format("%.2f", f);
	}
}