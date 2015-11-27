package by_4;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task4 
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
		
	
	public static void main(String[] args) 
	{
		
		//Входные данные
		double x1Min=-2, x1Max=2, y1Min=0, y1Max=4;
		double x2Min=-4, x2Max=4, y2Min=-3, y2Max=0;
		
		//координата x
		String xString;
		double xDouble;
		//координата y
		String yString;
		double yDouble;

		//Условие задания
		System.out.println("Input point coordinates (x,y) \n"
			+ "it'll show you if your point is in area \n");
				
		//Считывание чисел
		xString=InputData.readString("Input x");
		yString=InputData.readString("Input y");
		
		//Создание объекта класса
		Task4 Running = new Task4();
		//Выполнение программы
		try 
		{
			xDouble=Running.validString(xString);
			yDouble=Running.validString(yString);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//Создание прямоугольников
		Rectangle First = new Rectangle(x1Min ,x1Max ,y1Min ,y1Max);
		Rectangle Second = new Rectangle(x2Min ,x2Max ,y2Min ,y2Max);
		
		//Определение вхождения в фигуру и вывод на экран
		if(First.contains(xDouble, yDouble)==true | Second.contains(xDouble, yDouble)==true)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}

}
