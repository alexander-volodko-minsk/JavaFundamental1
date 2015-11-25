package by_4;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task4 
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
		
		
	//�����, ������������ ��������� ����� � �������
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
		
		//������� ������
		//������ �����
		String xString;
		Double xDouble;
		//������ �����
		String yString;
		Double yDouble;
		//��������� ����������
		String result;
		
		
		//������� �������
		System.out.println("Input point coordinates (x,y) \n"
			+ "it'll show you if your point is in area \n");
				
		//���������� �����
		xString=InputData.readString("Input x");
		yString=InputData.readString("Input y");
		
		//�������� ������� ������
		Task4 Running = new Task4();
		//���������� ���������
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
		//����������� ��������� � ������ � ����� �� �����
		result=Running.inArea(xDouble, yDouble);
		System.out.println(result);
	}

}
