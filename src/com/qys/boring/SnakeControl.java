package com.qys.boring;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeControl implements KeyListener{

	
//	LinkedList<Point> _snakeList = Snake.get_snakeList();
	Point dir = Snake.getDirection();
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP://方向不为下 方向改为上
			if(dir.get_y()!=10) {
				dir.set_y(-10);
				dir.set_x(0);
			}
			break;
		case KeyEvent.VK_DOWN://方向不为上 方向改为下
			if(dir.get_y()!=-10) {
				dir.set_y(10);
				dir.set_x(0);
			}
			break;
		case KeyEvent.VK_LEFT://方向不为右 方向改为左
			if(dir.get_x()!=10) {
				dir.set_x(-10);
				dir.set_y(0);
			}
			break;
		case KeyEvent.VK_RIGHT://方向不为左 方向改为右
			if(dir.get_x()!=-10) {
				dir.set_x(10);
				dir.set_y(0);
			}
		default:
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
