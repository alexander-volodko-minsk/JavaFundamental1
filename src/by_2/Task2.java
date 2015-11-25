package by_2;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task2 
{
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
	
	//�����, ����������� ��������� ���������
	public  double countExpression (double a, double b, double c)
	{
		double result=0;
		//���������� ���������� �� �������� �������
		try 
		{
		    result = (b + Math.sqrt(Math.pow(b,2)+4*a*c)) / 2*a -Math.pow(a,3)*c + Math.pow(b,-2);
		}
		//� ������ ������� ������� �� ���� ��� ���������� ����� �� �������������� ����� ������� ��������� �� ������
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
		//������� ������
		String aString, bString, cString;
		double aDouble, bDouble, cDouble;
		//���������
		double result;
		
		//������� �������
		System.out.println("Input three numerals \n"
			+ "it'll show you result of expression \n");
		
		//�������� ������� ������
		Task2 Running = new Task2();
		
		//���������� ���������
		//���������� ����� � �������� �� ����������
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
		
		//���������� ���������� ��������� � ����� ��� �� �����
		result=Running.countExpression(aDouble,bDouble,cDouble);
		System.out.println(result);
	}

}
