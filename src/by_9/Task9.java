package by_9;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task9 
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
			arrayString[i]=InputData.readString("Input "+(i+1)+" number of Array");
		}
		return arrayString;
	}
	
	//Метод, преобразующий String массив в double
	public double[] arrayToDouble (String[] arrayString) throws IncorrectNumberException
	{
		double[] arrayToDouble = new double [arrayString.length];

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
	
	
	//Метод формирующий комбинацию
	public double[] combination (double [] array1, double [] array2, int number ) throws IncorrectNumberException
	{

		double [] combinationArray= new double[array1.length+array2.length];
		if(number>=array1.length)
		{
			throw new IncorrectNumberException("Incorrect number");
		}
		for(int i=0; i<number; i++)
		{
			combinationArray[i]=array1[i];
		}
		
		for(int j=number;j<number+array2.length; j++)
		{
			combinationArray[j]=array2[j-number];
		}
		
		for(int k=number+array2.length;k<combinationArray.length; k++)
		{
			combinationArray[k]=array1[k-array2.length];
		}
		
		return combinationArray;
	}	
	
	
	//Метод выводящий массив на экран
	public  void showArray (double []arrayToShow)
	{
		//Печать числа
		for(int i=0; i<arrayToShow.length; i++)
		{
			System.out.println(arrayToShow[i]);
		}
	}

	
	
	public static void main(String[] args) 
	{
		//Входные данные
		//количество чисел
		String dimensionString1;
		int dimensionDouble1=0;
		
		String dimensionString2;
		int dimensionDouble2=0;
		
		String numberToCombinateString;
		int numberToCombinateInt=0;

		//массив чисел
		String numbersString1 [] = new String [dimensionDouble1];
		double numbersDouble1 [] = new double [dimensionDouble1];
		
		String numbersString2 [] = new String [dimensionDouble2];
		double numbersDouble2 [] = new double [dimensionDouble2];
		
		double combinationArray [] = new double[dimensionDouble1+dimensionDouble2];

		//Условие задания
		System.out.println("Input two arrays and element's number to combinate \n"
			+ "it'll show you the arrays combination \n");

		//Создание объекта класса
		Task9 Running = new Task9();
		//Ввод данных
		dimensionString1=InputData.readString("Input dimension of first array");//размерность1
		dimensionString2=InputData.readString("Input dimension of second array");//размерность2
		numberToCombinateString=InputData.readString("Input number to combinate");//номер
		
		try 
		{
			dimensionDouble1=Running.validString(dimensionString1);
			dimensionDouble2=Running.validString(dimensionString2);
			numberToCombinateInt=Running.validString(numberToCombinateString);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Specify the first array");
		numbersString1=Running.readArray(dimensionDouble1);//массив 1
		System.out.println("____________________");
		System.out.println("Specify the second array");
		numbersString2=Running.readArray(dimensionDouble2);//массив 2
		System.out.println("____________________");
		try 
		{
			numbersDouble1=Running.arrayToDouble(numbersString1);
			numbersDouble2=Running.arrayToDouble(numbersString2);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Комбинация
		try 
		{
			combinationArray=Running.combination(numbersDouble1, numbersDouble2, numberToCombinateInt);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		//Вывод на экран
		System.out.println("The combinations of arrays");
		System.out.println("____________________");
		Running.showArray(combinationArray);
		
	}
}
