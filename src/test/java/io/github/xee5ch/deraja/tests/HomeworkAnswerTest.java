package io.github.xee5ch.deraja.tests;

import io.github.xee5ch.deraja.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HomeworkAnswerTest {
		
	@Test
	public void testFahrenheitRankineCorrect()
	{
        HomeworkAnswer h = new HomeworkAnswer(new Fahrenheit("84.2"), Rankine.class, "543.5");
        assertEquals(h.getAnswerState(), "correct");
	}
	
	@Test
	public void testCelsiusKelvinCorrect()
	{
        HomeworkAnswer h = new HomeworkAnswer(new Celsius("-45.14"), Kelvin.class, "227.51");
        assertEquals(h.getAnswerState(), "correct");
	}
	
	@Test
	public void  testKelvinFahrenheitIncorrect()
	{
		HomeworkAnswer h = new HomeworkAnswer(new Kelvin("317.33"), Fahrenheit.class, "110.5");
		assertEquals(h.getAnswerState(), "incorrect");
	}
	
	@Test
	public void testRankineCelsiusIncorrect()
	{
		HomeworkAnswer h = new HomeworkAnswer(new Rankine("444.5"), Celsius.class, "-30.9");
		assertEquals(h.getAnswerState(), "incorrect");
	}
	
	@Test
	public void testFahrenheitRankineIncorrect()
	{
		HomeworkAnswer h = new HomeworkAnswer(new Fahrenheit("6.5"), Rankine.class, "dog");
		assertEquals(h.getAnswerState(), "incorrect");
	}
	
	@Test
	public void testErrorTemperatureCelsius()
	{
		HomeworkAnswer h = new HomeworkAnswer(new ErrorTemperature("dog"), Celsius.class, "45.32");
		assertEquals(h.getAnswerState(), "invalid");
	}
}