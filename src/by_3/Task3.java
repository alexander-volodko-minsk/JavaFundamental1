package by_3;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task3 
{
	private String cathetusA;//катет а
	private String cathetusB;//катет b
	
	//Конструктор класса, в котором передаем катеты
	public Task3 (String cathetusA, String cathetusB)
	{
		this.cathetusA=cathetusA;
		this.cathetusB=cathetusB;
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
	
	
	//Метод, вычисляющий площадь треугольника
	public  double countTriangleSquare (double a, double b)
	{
		//Данные
		double square;
		
		//Вычисление результата по заданной формуле
	    square = (a*b)/2;
		return square;
	}
	
	//Метод, вычисляющий периметр треугольника
	public  double countTrianglePerimeter (double a, double b)
	{
		//Данные
		double perimeter, hypotenuse;
		
		//Вычисление гипотенузы
		try 
		{
		hypotenuse = Math.sqrt(Math.pow(a, 2)+(Math.pow(b, 2)));
		}
		catch(NullPointerException e)
		{
			throw new NullPointerException();
		}
		catch(NumberFormatException e)
		{
			throw new NumberFormatException();
		}

		//Вычисление периметра 
	    perimeter = a+b+hypotenuse;
		return perimeter;
	}
	

	public static void main(String[] args) 
	{
		//Входные данные
		String aString;
		double aDouble;
		
		String bString;
		double bDouble;
		
		//Результат
		double triangleSquare, trianglePerimeter;
		
		//Условие задания
		System.out.println("Input two sides of triangle \n"
			+ "it'll show you it's square \n");
		
		aString=InputData.readString("Input a");
		bString=InputData.readString("Input b");
		//Создание объекта класса
		Task3 Running = new Task3(aString,bString);
		
		//Выполнение программы
		try
		{
			aDouble=Running.validString(Running.cathetusA);
			bDouble=Running.validString(Running.cathetusB);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}

		//Вычисление площади и периметра треугольника и вывод на экран
		triangleSquare=Running.countTriangleSquare(aDouble, bDouble);
		trianglePerimeter=Running.countTrianglePerimeter(aDouble, bDouble);
		System.out.println(triangleSquare+"-the square of triangle");
		System.out.println(trianglePerimeter+"-the perimeter of triangle");
	}

}
