package by_6;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task6 
{
	private int quantityOfNumbers;//���������� �����

	//����������� ������, � ������� �������� ���������� �������� �����
	public Task6 (int quantityOfNumbers)
	{
		this.quantityOfNumbers=quantityOfNumbers;
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

	
	//�����, ������������� String ������ � Double
	public Double[] arrayToDouble (String[] arrayString) throws IncorrectNumberException
	{
		Double[] arrayToDouble = new Double [arrayString.length];

		for(int i=0; i<arrayToDouble.length; i++)
		{
			try 
			{
				arrayToDouble[i]=Double.parseDouble(arrayString[i]);
			}
			catch (NumberFormatException e)
			{
				throw new IncorrectNumberException("Incorrect Format Of Numerals");
			}
		}
		return arrayToDouble;
	}
	
	
	//�����, ���������  ����������� �����
	public  Double minNumber (Double []numerals)
	{
		
		Double minNumber=numerals[0];
		for (int i=0; i<numerals.length; i++)
		{
			if(numerals[i]<minNumber)
			{
				minNumber=numerals[i];
			}
		}
		return minNumber;
	}
	
	
	//�����, ���������  ������������ �����
	public  Double maxNumber (Double []numerals)
	{
			
		Double maxNumber=numerals[0];
		for (int i=0; i<numerals.length; i++)
		{
			if(numerals[i]>maxNumber)
			{
				maxNumber=numerals[i];
			}
		}
		return maxNumber;
	}	
	
	
	public static void main(String[] args) 
	{

		//���������
		double minValue;//������������ ��������
		double maxValue;//������������ ��������
		double sumMaxMin;//������������ ��������
		
		//������� �������
		System.out.println("Input three numerals  \n"
			+ "it'll show you min and max value \n");
				
		//�������� ������� ������
		Task6 Running = new Task6(3);
		
		//���������� ���������
		//String ������ �����
		String numeralsString [] =Running.readArray(Running.quantityOfNumbers);
		
		//Double ������ �����
		Double numeralsDouble [] = new Double [Running.quantityOfNumbers];
		try 
		{
			numeralsDouble=Running.arrayToDouble(numeralsString);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		
		//���������� ��� � ���� ��������
		minValue=Running.minNumber(numeralsDouble);
		maxValue=Running.maxNumber(numeralsDouble);
		//����� ���������� �� �����
		sumMaxMin=minValue+maxValue;
		System.out.println("Sum of min and max values="+sumMaxMin);
	}
}

