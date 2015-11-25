package by_6;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task6 
{
	private int quantityOfNumbers;//количество чисел

	//Конструктор класса, в котором передаем количество вводимых чисел
	public Task6 (int quantityOfNumbers)
	{
		this.quantityOfNumbers=quantityOfNumbers;
	}
	
	
	//Метод, считывающий массив String из клавиатуры
	public String [] readArray(int quantity)
	{
		String [] arrayString=new String[quantity];
		for( int i=0; i<quantity; i++)
		{
			arrayString[i]=InputData.readString("Input "+(i+1)+" number");
		}
		return arrayString;
	}

	
	//Метод, преобразующий String массив в Double
	public Double[] arrayToDouble (String[] arrayString) throws IncorrectNumberException
	{
		Double[] arrayToDouble = new Double [arrayString.length];

		for(int i=0; i<arrayToDouble.length; i++)
		{
			try 
			{
				arrayToDouble[i]=Double.parseDouble(arrayString[i]);
			}
			catch (NumberFormatException e)
			{
				throw new IncorrectNumberException("Incorrect Format Of Numerals");
			}
		}
		return arrayToDouble;
	}
	
	
	//Метод, находящий  минимальное число
	public  Double minNumber (Double []numerals)
	{
		
		Double minNumber=numerals[0];
		for (int i=0; i<numerals.length; i++)
		{
			if(numerals[i]<minNumber)
			{
				minNumber=numerals[i];
			}
		}
		return minNumber;
	}
	
	
	//Метод, находящий  максимальное число
	public  Double maxNumber (Double []numerals)
	{
			
		Double maxNumber=numerals[0];
		for (int i=0; i<numerals.length; i++)
		{
			if(numerals[i]>maxNumber)
			{
				maxNumber=numerals[i];
			}
		}
		return maxNumber;
	}	
	
	
	public static void main(String[] args) 
	{

		//Результат
		double minValue;//минимальнрое значение
		double maxValue;//максимальное значение
		double sumMaxMin;//максимальное значение
		
		//Условие задания
		System.out.println("Input three numerals  \n"
			+ "it'll show you min and max value \n");
				
		//Создание объекта класса
		Task6 Running = new Task6(3);
		
		//Выполнение программы
		//String массив чисел
		String numeralsString [] =Running.readArray(Running.quantityOfNumbers);
		
		//Double массив чисел
		Double numeralsDouble [] = new Double [Running.quantityOfNumbers];
		try 
		{
			numeralsDouble=Running.arrayToDouble(numeralsString);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Нахождение мин и макс значения
		minValue=Running.minNumber(numeralsDouble);
		maxValue=Running.maxNumber(numeralsDouble);
		//Вывод результата на экран
		sumMaxMin=minValue+maxValue;
		System.out.println("Sum of min and max values="+sumMaxMin);
	}
}

