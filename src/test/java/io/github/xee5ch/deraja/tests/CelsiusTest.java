package io.github.xee5ch.deraja.tests;

import io.github.xee5ch.deraja.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class CelsiusTest {

	@Test
	public void testConstructorNoParamsDefaultValue()
	{
		Celsius c = new Celsius();
		BigDecimal degrees = new BigDecimal("0.00");
		
		assertEquals(degrees, c.degrees);
	}
	
}
