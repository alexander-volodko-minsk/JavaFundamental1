package by_7;

import java.util.HashMap;
import java.util.Map.Entry;

import by_1.IncorrectNumberException;
import by_1.InputData;

public class Task7 
{
	private String startPoint;//��������� �����
	private String endPoint;//�������� �����
	private String step;//���
	
	//����������� ������, � ������� �������� ��������� ����������
	public Task7 (String startPoint, String endPoint, String step)
	{
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.step=step;
	}
	
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
	
	//�����, ����������� ���������� ������
	public  void validParameters (double a, double b, double h) throws IncorrectNumberException
	{
		if(a>=b | h>(b-a) | h<=0)
		{
			throw new IncorrectNumberException("Incorrect Quantity Of Numerals");
		}
	}	
		
		
	//�����, ����������� ��������� ��������� � ����������� ����� ��������
	public HashMap<String, String> countExpression (double a, double b, double h)
	{
		HashMap <String, String> results = new HashMap<String, String>();
		double f;
		for(double x=a; x<=b; x=x+h)
		{
			f=Math.pow(Math.sin(x), 2)-Math.cos(2*x);
			String fString = new Double(f).toString();
			String xString = new Double(x).toString();
			results.put(xString, fString);
		}
		return results;
	}
	
	//�����, ��������� ����� �� �����
	public void showHashMap (HashMap<String, String> hashMapToShow)
	{
		//����� �� �����
		for (Entry<String, String> entry : hashMapToShow.entrySet())
		{
		    System.out.println(entry.getKey() + " | " + entry.getValue());
		    System.out.println("__________________________________________");
		}
	}

	
	public static void main(String[] args) 
	{
		//������� ������
		String aString, bString, hString;
		//���������
		HashMap<String, String> results = new HashMap<String, String>(); 
		
		//������� �������
		System.out.println("first point 'a', last point 'b' and step 'h' \n"
			+ "it'll show you the results of expression \n");
				
		//���������� �����
		aString=InputData.readString("Input a");		
		bString=InputData.readString("Input b");
		hString=InputData.readString("Input h");

		//�������� ������� ������
		Task7 Running = new Task7(aString,bString,hString);
		//���������� ���������
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
        //�������� ���������� ��������� ��������
		try
		{
			Running.validParameters(aDouble, bDouble, hDouble);
		} 
		catch (IncorrectNumberException e) 
		{
			System.out.println(e.getMessage());
			return;
		}
		//���������� ����������
		results=Running.countExpression(aDouble, bDouble, hDouble);
		//����� ���������� �� �����
		Running.showHashMap(results);
	}

}
