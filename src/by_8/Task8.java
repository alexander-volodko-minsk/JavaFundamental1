package by_8;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task8
{

	//Метод проверяющий формат введенных значений и возвращающий int
	public  int validString (String someString) throws IncorrectNumberException
	{
		int stringToInt=0;
		try 
		{
			stringToInt=Integer.parseInt(someString);
		}
		//В случае неправильного формата вводимых данных выводим сообщение об ошибке
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		//Проверяем натуральное ли число
		if(stringToInt<=0)
		{
			throw new IncorrectNumberException("Not a natural");
		}
		return stringToInt;
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
	
	//Метод, преобразующий String массив в Int
	public int[] arrayToInt (String[] arrayString) throws IncorrectNumberException
	{
		int[] arrayToDouble = new int [arrayString.length];

		for(int i=0; i<arrayToDouble.length; i++)
		{
			try 
			{
				arrayToDouble[i]=Integer.parseInt(arrayString[i]);
			}
			catch (NumberFormatException e)
			{
				throw new IncorrectNumberException("Incorrect Format Of Numerals");
			}
		}
		return arrayToDouble;
	}
	
	
	//Метод подсчитывающий сумму кратных элементов
	public int counter (int [] arrayToCount, int multiplicity ) throws IncorrectNumberException
	{
		//Проверка валидности значения кратности
		if(multiplicity==0)
		{
			throw new IncorrectNumberException("Incorrect multiplicity");
		}
		int condition=0;
		int sum=0;
		
		//Проверка кратности
		for(int i=0; i<arrayToCount.length; i++)
		{
			
			if(arrayToCount[i]%multiplicity==condition)
			{
				sum=sum+arrayToCount[i];
			}
		}
		return sum;
	}	
	
	
	public static void main(String[] args) 
	{
		//Входные данные
		//количество чисел
		String dimensionString;
		int dimensionInt=0;
		int sumOfElements;
		//кратность
		String multiplicityString;
		int multiplicityInt=0;
		
		//массив чисел
		String numbersString [] = new String [dimensionInt];
		int numbersInt [] = new int [dimensionInt];

		//Условие задания
		System.out.println("Input dimension, multiplicity and numbers of array   \n"
			+ "it'll show you the sum \n");

		//Создание объекта класса
		Task8 Running = new Task8();
		//Ввод данных
		dimensionString=InputData.readString("Input dimension");//размерность
		multiplicityString=InputData.readString("Input multiplicity");//кратность
		try 
		{
			dimensionInt=Running.validString(dimensionString);
			multiplicityInt=Running.validString(multiplicityString);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Ввод массива из клавиатуры
		numbersString=Running.readArray(dimensionInt);//массив
		try 
		{
			numbersInt=Running.arrayToInt(numbersString);//int массив
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Подсчет суммы
		try 
		{
			sumOfElements=Running.counter(numbersInt, multiplicityInt);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		//Вывод результата на экран
		System.out.println("The sum of multiplicityInt elements = "+sumOfElements);
	}
}



