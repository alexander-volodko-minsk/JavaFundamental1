package by_4;

public class Rectangle 
{
	
	double xMin, xMax, yMin, yMax;
	
	//Конструктор класса прямоугольник
	public Rectangle ( double xMin, double xMax, double yMin, double yMax)
	{
		this.xMin=xMin;
		this.xMax=xMax;
		this.yMin=yMin;
		this.yMax=yMax;
	}
	
	//Метод, определяющий, входит ли точка с введенными координатами в данный прямоугольник
	public boolean contains (double xPoint, double yPoint)
	{
		boolean belongs = false;
		
		if(xPoint>=xMin & xPoint<xMax & yPoint>=yMin & yPoint<yMax)
		{
			belongs = true;
		}
		return belongs;
	}
		
}
