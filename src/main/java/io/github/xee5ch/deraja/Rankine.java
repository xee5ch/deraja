package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public class Rankine extends Temperature {
	
	public static final BigDecimal CELSIUS_OFFSET = new BigDecimal("491.67");
	
	public static final BigDecimal FAHRENHEIT_OFFSET = new BigDecimal("459.67");
	
	public Rankine()
	{
		super();
	}
	
	public Rankine(BigDecimal degrees)
	{
		super(degrees);
	}
	
	public Rankine(String degrees)
	{
		super(degrees);
	}
	
	public static <T> BigDecimal parseDegrees(Temperature temp) throws NumberFormatException
	{
		if(temp == null)
		{
			throw new NumberFormatException(Rankine.class.getSimpleName() + ".parseDegrees cannot parse degrees from null");
		}
		
		else if(temp instanceof Rankine)
		{
			return ((Rankine) temp).degrees;
		}
		
		else if(temp instanceof Fahrenheit)
		{
			return ((Fahrenheit) temp).degrees.add(Fahrenheit.RANKINE_OFFSET);
		}
		
		else if (temp instanceof Celsius)
		{
			BigDecimal m = Utilities.toScaledValue(9.0f / 5.0f);
			
			return ((Celsius) temp).degrees.add(Celsius.RANKINE_OFFSET).multiply(m);
		}
		
		else if(temp instanceof Kelvin)
		{
			BigDecimal m = Utilities.toScaledValue(9.0f / 5.0f);
			
			return ((Kelvin) temp).degrees.multiply(m);
		}
		
		else if(temp instanceof ErrorTemperature)
		{
			return temp.degrees;
		}
		
		else
		{
			throw new NumberFormatException(Rankine.class.getSimpleName() + ".parseDegrees cannot parse invalid type");
		}
		
	}

}
