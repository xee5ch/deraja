package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public class Celsius extends Temperature {
	
	public static final BigDecimal FAHRENHEIT_OFFSET = new BigDecimal("32.00");
	
	public static final BigDecimal KELVIN_OFFSET = new BigDecimal("273.15");
	
	public static final BigDecimal RANKINE_OFFSET = new BigDecimal("273.15");
	
	public Celsius()
	{
		super();
	}
	
	public Celsius(BigDecimal degrees)
	{
		super(degrees);
	}
	
	public Celsius(String degrees)
	{
		super(degrees);
	}
	
	public static <T> BigDecimal parseDegrees(Temperature temp) throws NumberFormatException
	{
		if(temp == null)
		{
			throw new NumberFormatException(Celsius.class.getSimpleName() + ".parseDegrees cannot parse degrees from null");
		}
		
		else if(temp instanceof Celsius)
		{
			return ((Celsius) temp).degrees;
		}
		
		else if(temp instanceof Fahrenheit)
		{
			BigDecimal m = Utilities.toScaledValue(5.0f / 9.0f);
			
			BigDecimal s = Utilities.toScaledValue(32.0f);
			
			return (((Fahrenheit) temp).degrees.subtract(s)).multiply(m);
		}
		
		else if (temp instanceof Kelvin)
		{
			BigDecimal s = Kelvin.CELSIUS_OFFSET;
			return ((Kelvin) temp).degrees.subtract(s) ;
		}
		
		else if(temp instanceof Rankine)
		{
			BigDecimal m = Utilities.toScaledValue(5.0f / 9.0f);
			
			return (((Rankine) temp).degrees.subtract(Rankine.CELSIUS_OFFSET).multiply(m));
		}
		
		else if(temp instanceof ErrorTemperature)
		{
			return temp.degrees;
		}
		
		else
		{
			throw new NumberFormatException(Celsius.class.getSimpleName() + ".parseDegrees cannot parse degrees from invalid type");
		}
		
	}
}
