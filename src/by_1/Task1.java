package by_1;

public class Task1

{
	//����� ����������� ������ ��������� �������� � ������������� String � ������ char
	public  char[] stringToCharArray (String someString, int validQuantity) throws IncorrectNumberException
	{
		char[] charArray = new char[someString.length()];
		
		//�������� ������� ��������� �����
		try 
		{
			Integer.parseInt(someString);
		}
		catch (NumberFormatException e)
		{
			throw new IncorrectNumberException("Incorrect Format Of Numerals");
		}
		
		//�������� ����� �� ����� � �������� �� � ������
		charArray = someString.toCharArray();
						
		//�������� ���������� ��������� ����
		if(charArray.length!=validQuantity)
		{
			throw new IncorrectNumberException("Incorrect Quantity Of Numerals");
		}
		return charArray;
	}
	
	
	//�����, ����������� ��������� ���� ������ ���� � ��������� ���� ���� ��������������� �����
	public String varification(char [] charArray)
	{
		//��������� ���������
		String result="false";
		
		//������������ ��������
		int sumFirst=charArray[0]+charArray[1];//����� ������ ���� �����
		int sumSecond=charArray[2]+charArray[3];//����� ������ ���� �����

	    //�������� ���������
	    if(sumFirst==sumSecond)
		{
			result="true";
		}		
		return result;
	}
	
	
	public static void main(String[] args)
	
	{
		//������� ������
		String numberForVarification;
		int validNumber=4;// ���������� ����
		char [] numberInCharArray;
		//���������
		String result;
		
		//������� ������
		System.out.println("Number must consist of four numerals and in the result \n"
				+ "it'll show you if the sum of the first two \n"
				+ "numbers is equal to the sum of the last two \n");
		
		//���������� �����
		numberForVarification=InputData.readString("Input your number");
		
		//�������� ������� ������
		Task1 Running = new Task1();
		
		//���������� ���������
		try 
		{
			numberInCharArray=Running.stringToCharArray(numberForVarification, validNumber);
		} 
		catch (IncorrectNumberException e)
		{
			System.out.println(e.getMessage());
			return;
		}
		//��������� � ����� ���������� �� �����
		result=Running.varification(numberInCharArray);
		System.out.println(result);	
	}
}
