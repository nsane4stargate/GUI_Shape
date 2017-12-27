package main.se450.interfaces;

import java.awt.Graphics;

public interface IShape 
{
	void move(float x, float y);
	
	void move();
	
	void strategicmove();
	
	void draw(Graphics g);
}
      