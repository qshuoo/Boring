package com.qys.boring;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class SnakeControl implements KeyListener{

	
	LinkedList<Point> _snakeList = Snake.get_snakeList();
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			
			System.out.println("Up is press");
			Point p = _snakeList.get(0);
			Point newP = new Point(p.get_x(),p.get_y()-10);
			if(newP.get_y()>0) {
			_snakeList.add(0, newP);
			_snakeList.remove( _snakeList.size()-1);
			System.out.println(_snakeList);}
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Down is press");
			Point p1 = _snakeList.get(0);
			Point newP1 = new Point(p1.get_x(),p1.get_y()+10);
			if(newP1.get_y()<400) {
			_snakeList.add(0, newP1);
			_snakeList.remove( _snakeList.size()-1);}
			break;
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
