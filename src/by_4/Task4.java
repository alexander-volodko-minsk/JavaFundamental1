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
		
		
	//Метод, определяющий вхождение точки в область
	public  String inArea (double x, double y)
	{
		String belongs = "false";
		
		if((y>=-3 & y<=0 & x>=-4 & x<=4)|(y>0 & y<=4 & x>=-2 & x<=2))
		{
			belongs = "true";
		}
		return belongs;
	}

	
	public static void main(String[] args) 
	{
		
		//Входные данные
		//первый катет
		String xString;
		Double xDouble;
		//второй катет
		String yString;
		Double yDouble;
		//результат выполнения
		String result;
		
		
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
		//Определение вхождения в фигуру и вывод на экран
		result=Running.inArea(xDouble, yDouble);
		System.out.println(result);
	}

}
