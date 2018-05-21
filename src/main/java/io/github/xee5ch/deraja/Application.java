package io.github.xee5ch.deraja;

import java.util.Scanner;

public class Application {
	
	public static void main(String[] arguments) {
		
		Temperature inputTemp = new ErrorTemperature();
		String inputDegrees = Utilities.toScaledValue(Temperature.DEFAULT).toString();
		String defaultDegrees = Utilities.toScaledValue(Temperature.DEFAULT).toString();
		Class<?> targetTempType = ErrorTemperature.class;
		String studentResponse;
		
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Welcome to Temp Converter Grader%n");
		
		System.out.printf("Please enter a temperature:%n> ");
		String input = scanner.nextLine().toLowerCase();
		
		if(input == "q" || input == "quit")
		{
			System.out.printf("Exiting, goodbye%n");
			System.exit(0);
		}
		
		else
		{
			inputDegrees = input;
		}
		
		System.out.printf("Please enter temperature unit:%nEnter C/Celsius F/Fahrenheit K/Kelvin/ or R/Rankine%n> ");
		input = scanner.nextLine().toLowerCase();
		if(input == "q" || input == "quit")
		{
			System.out.printf("Exiting, goodbye%n");
			scanner.close();
			System.exit(0);
		}
		
		else
		{
			switch(input)
			{
			case "c":
			case "celsius":
				try
				{
					inputTemp = new Celsius(inputDegrees);	
				}
				
				catch(Exception ex)
				{
					inputTemp = new ErrorTemperature(defaultDegrees);
				}
				
				break;
			case "f":
			case "fahrenheit":
				try
				{
					inputTemp = new Fahrenheit(inputDegrees);
				}
				catch(Exception ex)
				{
					inputTemp = new ErrorTemperature(defaultDegrees);
				}
				
				break;
			case "k":
			case "kelvin":
				try
				{
					inputTemp = new Kelvin(inputDegrees);
				}
				
				catch(Exception ex)
				{
					inputTemp = new ErrorTemperature(defaultDegrees);
				}
				
				break;
			case "r":
			case "rankine":
				try
				{
					inputTemp = new Rankine(inputDegrees);
				}
				
				catch(Exception ex)
				{
					inputTemp = new ErrorTemperature(defaultDegrees);
				}
				
				break;
			default:
				inputTemp = new ErrorTemperature(defaultDegrees);
			}
		}
		
		System.out.printf("Please enter target unit for student answer:%nEnter C/Celsius F/Fahrenheit K/Kelvin/ or R/Rankine%n> ");
		input = scanner.nextLine().toLowerCase();
		if(input == "q" || input == "quit")
		{
			System.out.printf("Exiting, goodbye%n");
			scanner.close();
			System.exit(0);
		}
		
		else
		{
			switch(input)
			{
			case "c":
			case "celsius":
				targetTempType = Celsius.class;
				break;
			case "f":
			case "fahrenheit":
				targetTempType = Fahrenheit.class;
				break;
			case "k":
			case "kelvin":
				targetTempType = Kelvin.class;
				break;
			case "r":
			case "rankine":
				targetTempType = Rankine.class;
				break;
			default:
				targetTempType = ErrorTemperature.class;
			}
		}
		
		System.out.printf("Please enter student's answer:%n> ");
		input = scanner.nextLine();
		studentResponse = input;
		
		HomeworkAnswer h = new HomeworkAnswer(inputTemp, targetTempType, studentResponse);
		System.out.printf("%s%n", h.getAnswerState());
		
		scanner.close();
		System.exit(0);
	}
}
