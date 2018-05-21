package io.github.xee5ch.deraja.tests;

import io.github.xee5ch.deraja.*;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class KelvinTest {

	@Test
	public void testConstructorNoParamsDefaultValue()
	{
		Kelvin k = new Kelvin();
		BigDecimal degrees = new BigDecimal("0.00");
		
		assertEquals(k.degrees, degrees);
	}

}
