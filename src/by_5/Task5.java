package by_5;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task5 
{
	
	private int quantityOfNumbers;//���������� �����
	private int powAboveZero;//������� ���������� ���������������
	private int powSubZero;//������� ���������� �������������
	
	//����������� ������, � ������� �������� ���������� �������� ����� � ��������� �������
	public Task5 (int quantityOfNumbers, int powAboveZero, int powSubZero)
	{
		this.quantityOfNumbers=quantityOfNumbers;
		this.powAboveZero=powAboveZero;
		this.powSubZero=powSubZero;
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
	
	
	//�����, ���������� � �������
	public  double powNumber (double number , int powSubZero, int powAboveZero)
	{
		double powNumber;
		
			if(number<0)
			{
				powNumber=Math.pow(number,powSubZero);
		    }
			else
			{
				powNumber=Math.pow(number,powAboveZero);
			}
		return powNumber;
	}
	
	//�����, ��������� ������ �� �����
	public void showArray (double[] someString, String message)
	{
		//����� �� �����
		for(int i=0; i<someString.length; i++)
		{
			System.out.println((i+1)+message+someString[i]);
		}
	}
	

	public static void main(String[] args) 
	{
		//������� ������
		String message=" number in pow = ";
		
		//������� �������
		System.out.println("Input three numerals  \n"
			+ "it'll show you it's pows \n");
		
				
		//�������� ������� ������
		Task5 Running = new Task5(3,2,4);
		//������ ����� � �������� �����
		double[] numbersInPows = new double[Running.quantityOfNumbers]; 
		//���������� ���������
		for(int i=0; i<Running.quantityOfNumbers; i++)
		{
			//���������� �����
			String numberString=InputData.readString("Input "+(i+1)+" number");
			
			//������� String � double
			double numberDouble;
			try
			{
				numberDouble = Running.validString(numberString);
			} 
			catch (IncorrectNumberException e)
			{
				System.out.println(e.getMessage());
				return;
			}
			
			//���������� ����� � ������� � ����� �� �����
			double powOfNumber=Running.powNumber(numberDouble, Running.powSubZero, Running.powAboveZero);
			numbersInPows[i]=powOfNumber;
		}
		//����� ������� �� �����
		Running.showArray(numbersInPows,message);
		
	}
}
