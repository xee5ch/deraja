package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public class Kelvin extends Temperature {
	
	public static final BigDecimal CELSIUS_OFFSET = new BigDecimal("273.15");
	
	public static final BigDecimal FAHRENHEIT_OFFSET = new BigDecimal("459.67");
	
	public Kelvin()
	{
		super();
	}
	
	public Kelvin(BigDecimal degrees)
	{
		super(degrees);
	}
	
	public Kelvin(String degrees)
	{
		super(degrees);
	}
	
	public static <T> BigDecimal parseDegrees(Temperature temp) throws NumberFormatException
	{
		if(temp == null)
		{
			throw new NumberFormatException(Kelvin.class.getSimpleName() + ".parseDegrees cannot parse degrees from null");
		}
		
		else if(temp instanceof Kelvin)
		{
			return ((Kelvin) temp).degrees;
		}
		
		else if(temp instanceof Celsius)
		{
			return ((Celsius) temp).degrees.add(Celsius.KELVIN_OFFSET);
		}
		
		else if (temp instanceof Fahrenheit)
		{
			BigDecimal m = Utilities.toScaledValue(5.0f / 9.0f);
			
			return ((Fahrenheit) temp).degrees.add(Fahrenheit.KELVIN_OFFSET).multiply(m);
		}
		
		else if(temp instanceof Rankine)
		{
			BigDecimal m = Utilities.toScaledValue(5.0f / 9.0f);
			
			return ((Rankine) temp).degrees.multiply(m);
		}
		
		else if(temp instanceof ErrorTemperature)
		{
			return temp.degrees;
		}
		
		else {
			throw new NumberFormatException(Kelvin.class.getSimpleName() + ".parseDegrees cannot parse degrees from invalid type");
		}
	}

}
