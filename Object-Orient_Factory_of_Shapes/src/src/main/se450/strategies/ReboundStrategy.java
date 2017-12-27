package main.se450.strategies;

import java.awt.Dimension;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IStrategy;

public class ReboundStrategy implements IStrategy
{
	private Dimension dimension = new Dimension(0,0);
	
	public ReboundStrategy(Dimension newDimension)
	{
		dimension.setSize(newDimension);
	}

	@Override
	public Septuplet<?,?,?,?,?,?,?> execute(float left, float top, float right, float bottom, float x, float y, int color) 
	{
		/* Print statements to check positions
		System.out.println("width: " + dimension.width);
		System.out.println("height: " + dimension.height);
		System.out.println("left: " + left);
		System.out.println("right: " + right);
		System.out.println("top: " + top);
		System.out.println("bottom: " + bottom);
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		*/
		if (left < 0.0f || right > dimension.getWidth())
		{
			x = x *(-1);
		}
		if (bottom > dimension.getHeight() || top < 0.0f)
		{
			
			y = y * (-1);
	
		}
		return new Septuplet<Float,Float,Float,Float,Float,Float,Integer>(left,top,right,bottom,x,y,color);
	}
}