package by_1;

public class Task1

{
	//Метод проверяющий формат введенных значений и преобразующий String в массив char
	public  char[] stringToCharArray (String someString, int validQuantity) throws IncorrectNumberException
	{
		char[] charArray = new char[someString.length()];
		
		//Проверка формата введеного числа
		try 
		{
			Integer.parseInt(someString);
		}
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		
		//Разбивка числа на цифры и внесение их в массив
		charArray = someString.toCharArray();
						
		//Проверка количества введенных цифр
		if(charArray.length!=validQuantity)
		{
			throw new IncorrectNumberException("Incorrect Quantity Of Numerals");
		}
		return charArray;
	}
	
	
	//Метод, проверяющий равенство сумм первых двух и последних двух цифр четырехзначного числа
	public String varification(char [] charArray)
	{
		//Выводимое сообщение
		String result="false";
		
		//Сравниваемые величины
		int sumFirst=charArray[0]+charArray[1];//сумма первых двух чисел
		int sumSecond=charArray[2]+charArray[3];//сумма вторых двух чисел

	    //Проверка равенства
	    if(sumFirst==sumSecond)
		{
			result="true";
		}		
		return result;
	}
	
	
	public static void main(String[] args)
	
	{
		//Входные данные
		String numberForVarification;
		int validNumber=4;// количество цифр
		char [] numberInCharArray;
		//Результат
		String result;
		
		//Условие работы
		System.out.println("Number must consist of four numerals and in the result \n"
				+ "it'll show you if the sum of the first two \n"
				+ "numbers is equal to the sum of the last two \n");
		
		//Считывание числа
		numberForVarification=InputData.readString("Input your number");
		
		//Создание объекта класса
		Task1 Running = new Task1();
		
		//Выполнение программы
		try 
		{
			numberInCharArray=Running.stringToCharArray(numberForVarification, validNumber);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		//Получение и вывод результата на экран
		result=Running.varification(numberInCharArray);
		System.out.println(result);	
	}
}
