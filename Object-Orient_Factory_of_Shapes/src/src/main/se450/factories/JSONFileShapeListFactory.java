package main.se450.factories;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import main.se450.exceptions.BadShapeException;
import main.se450.exceptions.BadStrategyException;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;
import main.se450.utilities.Extractor;

public class JSONFileShapeListFactory
{
	private JSONFileShapeListFactory()
	{
	}
	
	public static ArrayList<IShape> makeShape(String fileName, final Dimension dimension)
	{
        ArrayList<IShape> iShapes = new ArrayList<IShape>();
        
		try
		{ 
	        JSONParser parser = new JSONParser();
	 
	        Object obj = parser.parse(new FileReader(fileName));
	 
	        JSONObject jsonObject = (JSONObject) obj;
	 
	        JSONArray jsonArray = (JSONArray) jsonObject.get("shapes");
	        
	        Iterator<?> jsonIterator = jsonArray.iterator();
	        while (jsonIterator.hasNext())
	        {
	        	JSONObject someShape = (JSONObject)jsonIterator.next();
	        	if (someShape.containsKey("type"))
	        	{
	        		try
	        		{
	        			try
	        			{
							IStrategy iStrategy = StrategyFactory.makeStrategy(someShape.get("borders").toString(), dimension);
						
			        		IShape iShape = ShapeFactory.makeShape(someShape.get("type").toString(), 
					        									   Extractor.extractFloat(someShape.get("left")),
					        									   Extractor.extractFloat(someShape.get("top")),
					        									   Extractor.extractFloat(someShape.get("right")),
					        									   Extractor.extractFloat(someShape.get("bottom")),
					        									   Extractor.extractFloat(someShape.get("x")),
					        									   Extractor.extractFloat(someShape.get("y")),
					        									   Extractor.extractFloat(someShape.get("rotation")),
					        									   Extractor.extractInteger(someShape.get("color")),
			        											   iStrategy);
		        		
			        		iShapes.add(iShape);
	        			}
	        			catch (BadStrategyException e)
	        			{
		        			System.out.println(e);
	        			}
	        		}
	        		catch (BadShapeException e)
	        		{
	        			System.out.println(e);
	        		}
	        	}
	        	
	        }
		}
        catch(FileNotFoundException eFileNotFound)
        {
        }
        catch(IOException eIOException)
        {
        	
        }
        catch(ParseException eParseException)
        {
        }
		
		return iShapes;
	}
}
      