package io.github.xee5ch.deraja;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeworkAnswer {
	
	private enum AnswerState {
		INCORRECT, CORRECT, INVALID
	}
	
	public Temperature inputTemp;
	
	public Temperature targetTemp;
	
	public Class<?>  targetTempType;
	
	public String studentResponse;
	
	private AnswerState answerState;
	
	public HomeworkAnswer(Temperature inputTemp, Class<?>  targetTempType, String studentResponse)
	{
		if(!isValidType(inputTemp.getClass()))
		{
			this.inputTemp = new ErrorTemperature();
		}
		
		else
		{
			this.inputTemp = inputTemp;
		}
		
		this.targetTempType = targetTempType;
		this.studentResponse = studentResponse;
		this.targetTemp = setTargetTemp();
		this.answerState = setAnswerState();
	}
	
	public static boolean isValidType(Class<?>  type)
	{
		if(type == Celsius.class)
		{
			return true;
		}
		
		else if(type == Fahrenheit.class)
		{
			return true;
		}
		
		else if(type == Kelvin.class)
		{
			return true;
		}
		
		else if(type == Rankine.class)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}
	
	public String getAnswerState()
	{
		return answerState
				.toString()
				.toLowerCase();
	}
	
	private AnswerState setAnswerState()
	{
		if(inputTemp.getClass() == ErrorTemperature.class)
		{
			return AnswerState.INVALID;
		}
		
		else if(targetTemp.getClass() == ErrorTemperature.class)
		{
			return AnswerState.INCORRECT;
		}
		
		else if(isStudentResponseCorrect())
		{
			return AnswerState.CORRECT;
		}
		
		else
		{
			return AnswerState.INCORRECT;
		}
	}
	
	private Temperature setTargetTemp()
	{	
		
		if(!isValidType(targetTempType))
		{
			return new ErrorTemperature();
		}
		
		else if(targetTempType == Celsius.class)
		{
			try
			{
				return new Celsius(Celsius.parseDegrees(inputTemp));
			}
			catch(NumberFormatException ex)
			{
				return new ErrorTemperature();
			}
		}
		
		else if(targetTempType == Fahrenheit.class)
		{
			try
			{
				new Fahrenheit(Fahrenheit.parseDegrees(inputTemp));
			}
			
			catch(NumberFormatException ex)
			{
				return new ErrorTemperature();
			}
			
		}
		
		else if(targetTempType == Kelvin.class)
		{
			try
			{
				return new Kelvin(Kelvin.parseDegrees(inputTemp));
			}
			
			catch(NumberFormatException ex)
			{
				return new ErrorTemperature();
			}
		}
		
		else if(targetTempType == Rankine.class)
		{
			try
			{
				return new Rankine(Rankine.parseDegrees(inputTemp));
			}
			
			catch(NumberFormatException ex)
			{
				return new ErrorTemperature();
			}
		}
		
		else
		{
			return new ErrorTemperature();
		}
		
		return new ErrorTemperature();
		
	}
	
	private boolean isStudentResponseCorrect()
	{
		BigDecimal studentDegrees;
		
		try
		{
			 studentDegrees = new BigDecimal(studentResponse);
		}
		
		catch(Exception ex)
		{
			return false;
		}
		
		BigDecimal i = round(targetTemp.degrees);
		BigDecimal s = round(studentDegrees);
		
		int delta = i.compareTo(s);
		
		return delta == 0;
	}
	
	private static BigDecimal round(BigDecimal degrees)
	{
		return degrees.setScale(0, RoundingMode.HALF_UP);
	}
}
