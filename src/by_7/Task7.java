package by_7;

import java.util.HashMap;
import java.util.Map.Entry;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task7 
{
	private String startPoint;//начальная точка
	private String endPoint;//конечная точка
	private String step;//шаг
	
	//Конструктор класса, в котором передаем параметры вычислений
	public Task7 (String startPoint, String endPoint, String step)
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.step=step;
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
	
	//Метод, проверяющий валидность данных
	public  void validParameters (double a, double b, double h) throws IncorrectNumberException
	{
		if(a>=b | h>(b-a) | h<=0)
		{
			throw new IncorrectNumberException("Incorrect Quantity Of Numerals");
		}
	}	
		
		
	//Метод, вычисляющий результат выражения и формирующий карту значений
	public HashMap<String, String> countExpression (double a, double b, double h)
	{
		HashMap <String, String> results = new HashMap<String, String>();
		double f;
		for(double x=a; x<=b; x=x+h)
		{
			double expression1 = Math.pow(Math.sin(x), 2);
			double expression2 = Math.cos(2*x);
			//Вычисление значения функции
			f=expression1-expression2;
			//Перевод в String
			String fString = new Double(f).toString();
			String xString = new Double(x).toString();
			//Добавление в Map
			results.put(xString, fString);
		}
		return results;
	}
	
	//Метод, выводящий карту на экран
	public void showHashMap (HashMap<String, String> hashMapToShow)
	{
		//Вывод на экран
		for (Entry<String, String> entry : hashMapToShow.entrySet())
		{
		    System.out.println(entry.getKey() + " | " + entry.getValue());
		    System.out.println("__________________________________________");
		}
	}

	
	public static void main(String[] args) 
	{
		//Входные данные
		String aString, bString, hString;
		//Результат
		HashMap<String, String> results = new HashMap<String, String>(); 
		
		//Условие задания
		System.out.println("first point 'a', last point 'b' and step 'h' \n"
			+ "it'll show you the results of expression \n");
				
		//Считывание чисел
		aString=InputData.readString("Input a");		
		bString=InputData.readString("Input b");
		hString=InputData.readString("Input h");

		//Создание объекта класса
		Task7 Running = new Task7(aString,bString,hString);
		//Выполнение программы
		double aDouble,bDouble,hDouble;
		try 
		{
			aDouble = Running.validString(Running.startPoint);
			bDouble=Running.validString(Running.endPoint);
			hDouble=Running.validString(Running.step);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
        //Проверка валидности введенных значений
		try
		{
			Running.validParameters(aDouble, bDouble, hDouble);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		//Вычисление результата
		results=Running.countExpression(aDouble, bDouble, hDouble);
		//Вывод результата на экран
		Running.showHashMap(results);
	}

}
