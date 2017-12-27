package main.se450.singletons;

import java.util.ArrayList;

import main.se450.interfaces.IShape;

public class ShapeList
{
	@SuppressWarnings("unused")
	private static ShapeList shapeList = null;
	
	@SuppressWarnings("unused")
	private ArrayList<IShape> iShapes = null;
	
	static
	{
		shapeList = new ShapeList();		
	}
	
    private ShapeList()
    {
    	iShapes = new ArrayList<IShape>();
    }
    
	public final static ShapeList getShapeList() 
	{
		return shapeList;
	}
	
	public synchronized final ArrayList<IShape> getShapes()
	{
		return iShapes;
	}

	public synchronized void addShapes(final ArrayList<IShape> iShapeList)
	{
			getShapes().addAll(iShapeList);
	}
}
      