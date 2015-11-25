package by_3;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task3 
{
	private String cathetusA;//����� �
	private String cathetusB;//����� b
	
	//����������� ������, � ������� �������� ������
	public Task3 (String cathetusA, String cathetusB)
	{
		this.cathetusA=cathetusA;
		this.cathetusB=cathetusB;
	}	
	
	//�����, ����������� ������ ��������� �������� � ���������� String � double
	public  double validString (String someString) throws IncorrectNumberException
	{
		double stringToDouble=0;
		try 
		{
			stringToDouble=Double.parseDouble(someString);
		}
		//� ������ ������������� ������� �������� ������ ������� ��������� �� ������
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		return stringToDouble;
	}
	
	
	//�����, ����������� ������� ������������
	public  double countTriangleSquare (double a, double b)
	{
		//������
		double square;
		
		//���������� ���������� �� �������� �������
	    square = (a*b)/2;
		return square;
	}
	
	//�����, ����������� �������� ������������
	public  double countTrianglePerimeter (double a, double b)
	{
		//������
		double perimeter, hypotenuse;
		
		//���������� ����������
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

		//���������� ��������� 
	    perimeter = a+b+hypotenuse;
		return perimeter;
	}
	

	public static void main(String[] args) 
	{
		//������� ������
		String aString;
		double aDouble;
		
		String bString;
		double bDouble;
		
		//���������
		double triangleSquare, trianglePerimeter;
		
		//������� �������
		System.out.println("Input two sides of triangle \n"
			+ "it'll show you it's square \n");
		
		aString=InputData.readString("Input a");
		bString=InputData.readString("Input b");
		//�������� ������� ������
		Task3 Running = new Task3(aString,bString);
		
		//���������� ���������
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

		//���������� ������� � ��������� ������������ � ����� �� �����
		triangleSquare=Running.countTriangleSquare(aDouble, bDouble);
		trianglePerimeter=Running.countTrianglePerimeter(aDouble, bDouble);
		System.out.println(triangleSquare+"-the square of triangle");
		System.out.println(trianglePerimeter+"-the perimeter of triangle");
	}

}
