package by_10;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task10 
{
	//Размер матрицы n
	private String n;
	 //Конструктор класса, передаем параметр n
	public Task10(String n)
	{
		this.n=n;
	}
	
	//Метод проверяющий формат введенного значения и возвращающий int
	public  int validString (String someString) throws IncorrectNumberException
	{
		int evenNumeral=2;//делитель
		int condition=0;//условие четности
		
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
		//Проверяем четное ли число
		if(stringToInt%evenNumeral!=condition)
		{
			throw new IncorrectNumberException("Not an even numeral");
		}
		return stringToInt;
	}
	
	//Метод формирующий матрицу заданного образца
	public int[][] formingMatrix(int verticalSize, int horizontalSize)
	{
		
		int[][] matrix = new int[verticalSize][horizontalSize];
		
        // Цикл по первой размерности (первые квадратные скобки)
        for (int i = 0; i < verticalSize; i++)
        {
        	if(i%2!=0)//нечетность
        	{
        		// Цикл по второй размерности (вторые квадратные скобки)
                for (int j = 0; j < horizontalSize; j++)
                {
                	matrix[i][j] = horizontalSize-j;
                }
        	}
        	else
        	{
        		// Цикл по второй размерности (вторые квадратные скобки)
                for (int j = horizontalSize-1; j > (0-1); j--)
                {
                	matrix[i][j] = j+1;
                }
        	}
        }
		return matrix;
	}
	

	public static void main(String[] args) 
	{

		//Результат
		String dimensionString;//размер
		int dimensionInt=0;//размер
		int [][] matrix = new int [dimensionInt][dimensionInt];

		//Условие задания
		System.out.println("Input dimension of the square matrix  \n"
			+ "it'll show you the matrix \n");

		//Считывание числа
		dimensionString=InputData.readString("Input dimension");
		
		//Создание объекта класса
		Task10 Running = new Task10(dimensionString);
		
		try
		{
			dimensionInt=Running.validString(Running.n);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		matrix=Running.formingMatrix(dimensionInt, dimensionInt);
	}
}
