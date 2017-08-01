package com.qys.boring;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SnakeControl implements KeyListener{

	
	ArrayList<Point> _snakeList = Snake.get_snakeList();
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP:
			System.out.println("Up is press");
			Point p = _snakeList.get(0);
			Point newP = new Point(p.get_x(),p.get_y()-10);
			_snakeList.add(0, newP);
			_snakeList.remove( _snakeList.size()-1);
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
