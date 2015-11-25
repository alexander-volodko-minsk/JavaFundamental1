package by_8;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task8
{

	//����� ����������� ������ ��������� �������� � ������������ int
	public  int validString (String someString) throws IncorrectNumberException
	{
		int stringToInt=0;
		try 
		{
			stringToInt=Integer.parseInt(someString);
		}
		//� ������ ������������� ������� �������� ������ ������� ��������� �� ������
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		//��������� ����������� �� �����
		if(stringToInt<=0)
		{
			throw new IncorrectNumberException("Not a natural");
		}
		return stringToInt;
	}
		
	//�����, ����������� ������ String �� ����������
	public String [] readArray(int quantity)
	{
		String [] arrayString=new String[quantity];
		for( int i=0; i<quantity; i++)
		{
			arrayString[i]=InputData.readString("Input "+(i+1)+" number");
		}
		return arrayString;
	}
	
	//�����, ������������� String ������ � Int
	public int[] arrayToInt (String[] arrayString) throws IncorrectNumberException
	{
		int[] arrayToDouble = new int [arrayString.length];

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
	
	
	//����� �������������� ����� ������� ���������
	public int counter (int [] arrayToCount, int multiplicity ) throws IncorrectNumberException
	{
		//�������� ���������� �������� ���������
		if(multiplicity==0)
		{
			throw new IncorrectNumberException("Incorrect multiplicity");
		}
		int condition=0;
		int sum=0;
		
		//�������� ���������
		for(int i=0; i<arrayToCount.length; i++)
		{
			
			if(arrayToCount[i]%multiplicity==condition)
			{
				sum=sum+arrayToCount[i];
			}
		}
		return sum;
	}	
	
	
	public static void main(String[] args) 
	{
		//������� ������
		//���������� �����
		String dimensionString;
		int dimensionInt=0;
		int sumOfElements;
		//���������
		String multiplicityString;
		int multiplicityInt=0;
		
		//������ �����
		String numbersString [] = new String [dimensionInt];
		int numbersInt [] = new int [dimensionInt];

		//������� �������
		System.out.println("Input dimension, multiplicity and numbers of array   \n"
			+ "it'll show you the sum \n");

		//�������� ������� ������
		Task8 Running = new Task8();
		//���� ������
		dimensionString=InputData.readString("Input dimension");//�����������
		multiplicityString=InputData.readString("Input multiplicity");//���������
		try 
		{
			dimensionInt=Running.validString(dimensionString);
			multiplicityInt=Running.validString(multiplicityString);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//���� ������� �� ����������
		numbersString=Running.readArray(dimensionInt);//������
		try 
		{
			numbersInt=Running.arrayToInt(numbersString);//int ������
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//������� �����
		try 
		{
			sumOfElements=Running.counter(numbersInt, multiplicityInt);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		//����� ���������� �� �����
		System.out.println("The sum of multiplicityInt elements = "+sumOfElements);
	}
}



