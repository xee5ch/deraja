package io.github.xee5ch.deraja;

import static io.github.xee5ch.deraja.Utilities.FIVE;

import static io.github.xee5ch.deraja.Utilities.NINE;

import java.math.BigDecimal;

public class Fahrenheit extends Temperature {
	
	
	public static final BigDecimal KELVIN_OFFSET = new BigDecimal("459.67");
	
	public static final BigDecimal RANKINE_OFFSET = new BigDecimal("459.67");
	
	public Fahrenheit()
	{
		super();
	}
	
	public Fahrenheit(BigDecimal degrees)
	{
		super(degrees);
	}
	
	public Fahrenheit(String degrees)
	{
		super(degrees);
	}
	
	public static <T> BigDecimal parseDegrees(Temperature temp) throws NumberFormatException
	{
		if(temp == null)
		{
			throw new NumberFormatException(Fahrenheit.class.getSimpleName() + ".parseDegrees cannot parse degrees from null");
		}
		
		else if(temp instanceof Fahrenheit)
		{
			return ((Fahrenheit) temp).degrees;
		}
		
		else if(temp instanceof Celsius)
		{
			
			return ((Celsius) temp).degrees
					.multiply(NINE)
					.divide(FIVE)
					.add(Celsius.FAHRENHEIT_OFFSET);
		}
		
		else if (temp instanceof Kelvin)
		{
			
			return ((Kelvin) temp).degrees
					.multiply(NINE)
					.divide(FIVE)
					.subtract(Kelvin.FAHRENHEIT_OFFSET);
		}
		
		else if(temp instanceof Rankine)
		{
			return ((Rankine) temp).degrees
					.subtract(Rankine.FAHRENHEIT_OFFSET);
		}
		
		else if(temp instanceof ErrorTemperature)
		{
			return temp.degrees;
		}
		
		else {
			throw new NumberFormatException(Fahrenheit.class.getSimpleName() + ".parseDegrees cannot parse degrees from invalid type");
		}
		
	}
	
	
}
