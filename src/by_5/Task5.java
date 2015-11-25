package by_5;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task5 
{
	
	private int quantityOfNumbers;//количество чисел
	private int powAboveZero;//степень возведения неотрицательных
	private int powSubZero;//степень возведения отрицательных
	
	//Конструктор класса, в котором передаем количество вводимых чисел и требуемые степени
	public Task5 (int quantityOfNumbers, int powAboveZero, int powSubZero)
	{
		this.quantityOfNumbers=quantityOfNumbers;
		this.powAboveZero=powAboveZero;
		this.powSubZero=powSubZero;
	}

	
	//Метод, проверяющий формат введенных значений и приводящий String к double
	public  double validString (String someString) throws IncorrectNumberException
	{
		double stringToDouble=0;
		try 
		{
			stringToDouble=Double.parseDouble(someString);
		}
		//В случае неправильного формата вводимых данных выводим сообщение об ошибке
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		return stringToDouble;
	}
	
	
	//Метод, возводящий в степень
	public  double powNumber (double number , int powSubZero, int powAboveZero)
	{
		double powNumber;
		
			if(number<0)
			{
				powNumber=Math.pow(number,powSubZero);
		    }
			else
			{
				powNumber=Math.pow(number,powAboveZero);
			}
		return powNumber;
	}
	
	//Метод, выводящий массив на экран
	public void showArray (double[] someString, String message)
	{
		//Вывод на экран
		for(int i=0; i<someString.length; i++)
		{
			System.out.println((i+1)+message+someString[i]);
		}
	}
	

	public static void main(String[] args) 
	{
		//Входные данные
		String message=" number in pow = ";
		
		//Условие задания
		System.out.println("Input three numerals  \n"
			+ "it'll show you it's pows \n");
		
				
		//Создание объекта класса
		Task5 Running = new Task5(3,2,4);
		//Массив чисел в степенях чисел
		double[] numbersInPows = new double[Running.quantityOfNumbers]; 
		//Выполнение программы
		for(int i=0; i<Running.quantityOfNumbers; i++)
		{
			//Считывание числа
			String numberString=InputData.readString("Input "+(i+1)+" number");
			
			//Перевод String в double
			double numberDouble;
			try
			{
				numberDouble = Running.validString(numberString);
			} 
			catch (IncorrectNumberException e)
			{
				System.out.println(e.getMessage());
				return;
			}
			
			//Возведение чисел в степень и вывод на экран
			double powOfNumber=Running.powNumber(numberDouble, Running.powSubZero, Running.powAboveZero);
			numbersInPows[i]=powOfNumber;
		}
		//Вывод массива на экран
		Running.showArray(numbersInPows,message);
		
	}
}
