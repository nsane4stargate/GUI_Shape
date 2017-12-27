package main.se450.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.se450.interfaces.IStrategy;

public class Ship extends Shape
{
	//Read only pattern
	
	private ArrayList<Shape> lines = new ArrayList<Shape>(4);
	
	private Line bottomLeft_1, bottomRight_2, leftLine_3, rightLine_4;
	
	public Ship(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);

    	makeShip();
    }

	public float getMidpointX()
    {
        return ((getLeft()+getRight())/2);
    }	
	
    public float getMidpointY()
    {
        return ((getTop() + getBottom())/2);
        
    }
    @Override
    public void strategicmove()
    {
        super.strategicmove();

        makeShip();
    }

    private void makeShip() {
    	lines.clear();
    	
    	lines.add(bottomLeft_1 = new Line(getLeft(),getBottom(),getMidpointX(), getTop(),getX(),getY(),getRotation(),getColor(),getStrategy()));
    	lines.add(bottomRight_2 = new Line(getLeft(),getBottom(),getMidpointX(), getMidpointY(),getX(),getY(),getRotation(),getColor(),getStrategy()));
    	lines.add(leftLine_3 = new Line(getMidpointX(),getTop(),getRight(), getBottom(),getX(),getY(),getRotation(),getColor(),getStrategy()));
    	lines.add(rightLine_4 = new Line(getMidpointX(),getMidpointY(),getRight(), getBottom(),getX(),getY(),getRotation(),getColor(),getStrategy()));
    	
   	}
	@Override
	public void draw(Graphics g)
	{
		Iterator<Shape> iLines = lines.iterator();
		while(iLines.hasNext()){
			iLines.next().draw(g);
		}
		
	}	    
}
 
    