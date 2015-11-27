package by_2;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task2 
{
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
	
	//Метод, вычисляющий результат выражения
	public  double countExpression (double a, double b, double c)
	{
		double result=0;
		//Вычисление результата по заданной формуле
		try 
		{
			double expression1=(b + Math.sqrt(Math.pow(b,2)+4*a*c));
			double expression2=2*a;
			double expression3=Math.pow(a,3)*c;
			double expression4=Math.pow(b,-2);
					
		    result = expression1 / expression2 -expression3 +expression4;
		}
		//В случае попытки деления на ноль или вычисления корня из отрицательного числа выводим сообщение об ошибке
		catch(NullPointerException e)
		{
			throw new NullPointerException();
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException();
		}
		return result;
	}
	
	public static void main(String[] args)
	{
		//Входные данные
		String aString, bString, cString;
		double aDouble, bDouble, cDouble;
		//Результат
		double result;
		
		//Условие задания
		System.out.println("Input three numerals \n"
			+ "it'll show you result of expression \n");
		
		//Создание объекта класса
		Task2 Running = new Task2();
		
		//Выполнение программы
		//Считывание чисел и проверка их валидности
		try
		{
			aString=InputData.readString("Input a");
			aDouble=Running.validString(aString);
			bString=InputData.readString("Input b");
			bDouble=Running.validString(bString);
			cString=InputData.readString("Input c");
			cDouble=Running.validString(cString);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Вычисление результата выражения и вывод его на экран
		result=Running.countExpression(aDouble,bDouble,cDouble);
		System.out.println(result);
	}

}
