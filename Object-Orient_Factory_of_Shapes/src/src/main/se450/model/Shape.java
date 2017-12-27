package main.se450.model;

import java.awt.Graphics;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;

public abstract class Shape implements IShape
{
	private float     left      = 0.0f;
	private float     top       = 0.0f;
	private float     right     = 0.0f;
	private float     bottom    = 0.0f;
	private float     x         = 0.0f;
	private float     y         = 0.0f;
	private float     rotation  = 0.0f;
	private int       color     = 0;
	private IStrategy iStrategy = null;
	
	//Read only pattern
	public Shape(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iiStrategy)
	{
		left      = nLeft;
		top       = nTop;
		right     = nRight;
		bottom    = nBottom;
		x         = nX;
		y         = nY;
		rotation  = nRotation;
		color     = nColor;
		iStrategy = iiStrategy;
	}
	
	public float getLeft()
	{
		return left;
	}
	
	public float getTop()
	{
		return top;
	}
	
	public float getRight()
	{
		return right;
	}
	
	public float getBottom()
	{
		return bottom;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}

	public float getRotation()
	{
		return rotation;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public float getWidth()
	{
		return getRight() - getLeft();
	}
	
	public float getHeight()
	{
		return getBottom() - getTop();
	}
	
	public final IStrategy getStrategy()
	{
		return iStrategy;
	}
	
	@Override
	public void move() 
	{
		left   += x;
		top    += y;
		right  += x;
		bottom += y;
	}

	@Override
	public void move(float nX, float nY) 
	{
		left   += nX;
		top    += nY;
		right  += nX;
		bottom += nY;
	}
	
    @Override
    public void strategicmove()
    {
    	move();
    	
    	Septuplet<?,?,?,?,?,?,?> septuplet = iStrategy.execute(left, top, right, bottom, x, y, color);
    	
    	left   = (Float)septuplet.getT1();
    	top    = (Float)septuplet.getT2();
    	right  = (Float)septuplet.getT3();
    	bottom = (Float)septuplet.getT4();
    	x      = (Float)septuplet.getT5();
    	y      = (Float)septuplet.getT6();
    	color  = (Integer)septuplet.getT7();
    }
    
	@Override
	public abstract void draw(Graphics g);
}
      