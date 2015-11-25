package by_1;

import java.util.Scanner;

public class InputData
{
	// ввод
	static String stringInput;
		
	// статический метод ввода данных, в качестве параметра передаем сообщение
	public static String readString(String message) 
	{
		System.out.println(message);
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		return stringInput = scan.nextLine();
	}
}
