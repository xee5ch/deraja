package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public abstract class Temperature {
	
	public static final float DEFAULT = 0.0f;
	
	public BigDecimal degrees;
	
	protected Temperature()
	{
		this.degrees = Utilities.toScaledValue(DEFAULT);
	}
	
	public Temperature(BigDecimal degrees)
	{
		this.degrees = degrees;
	}
	
	public Temperature(String degrees)
	{
		try
		{
			this.degrees = new BigDecimal(Utilities.toScaledString(degrees));
		}
		
		catch(NumberFormatException e)
		{
			this.degrees = Utilities.toScaledValue(DEFAULT);
		}
	}
}
