package io.github.xee5ch.deraja.tests;

import io.github.xee5ch.deraja.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class FahrenheitTest {

	@Test
	public void testConstructorNoParamsDefaultValue()
	{
		Fahrenheit f = new Fahrenheit();
		BigDecimal degrees = new BigDecimal("0.00");
		
		assertEquals(f.degrees, degrees);
	}

}
