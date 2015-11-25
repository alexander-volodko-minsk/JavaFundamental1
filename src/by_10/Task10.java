package by_10;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task10 
{
	//������ ������� n
	private String n;
	 //����������� ������, �������� �������� n
	public Task10(String n)
	{
		this.n=n;
	}
	
	//����� ����������� ������ ���������� �������� � ������������ int
	public  int validString (String someString) throws IncorrectNumberException
	{
		int evenNumeral=2;//��������
		int condition=0;//������� ��������
		
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
		//��������� ������ �� �����
		if(stringToInt%evenNumeral!=condition)
		{
			throw new IncorrectNumberException("Not an even numeral");
		}
		return stringToInt;
	}
	
	//����� ����������� ������� ��������� �������
	public int[][] formingMatrix(int verticalSize, int horizontalSize)
	{
		
		int[][] matrix = new int[verticalSize][horizontalSize];
		
        // ���� �� ������ ����������� (������ ���������� ������)
        for (int i = 0; i < verticalSize; i++)
        {
        	if(i%2!=0)//����������
        	{
        		// ���� �� ������ ����������� (������ ���������� ������)
                for (int j = 0; j < horizontalSize; j++)
                {
                	matrix[i][j] = horizontalSize-j;
                }
        	}
        	else
        	{
        		// ���� �� ������ ����������� (������ ���������� ������)
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

		//���������
		String dimensionString;//������
		int dimensionInt=0;//������
		int [][] matrix = new int [dimensionInt][dimensionInt];

		//������� �������
		System.out.println("Input dimension of the square matrix  \n"
			+ "it'll show you the matrix \n");

		//���������� �����
		dimensionString=InputData.readString("Input dimension");
		
		//�������� ������� ������
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
