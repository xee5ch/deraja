package io.github.xee5ch.deraja;

import java.math.BigDecimal;

public class ErrorTemperature extends Temperature {
	
	public ErrorTemperature()
	{
		super();
	}
	
	public ErrorTemperature(BigDecimal degrees)
	{
		super(degrees);
	}
	
	public ErrorTemperature(String degrees)
	{
		super(degrees);
	}
}
