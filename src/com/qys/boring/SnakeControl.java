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
		case KeyEvent.VK_UP://����Ϊ�� �����Ϊ��
			if(dir.get_y()!=10) {
				dir.set_y(-10);
				dir.set_x(0);
			}
			break;
		case KeyEvent.VK_DOWN://����Ϊ�� �����Ϊ��
			if(dir.get_y()!=-10) {
				dir.set_y(10);
				dir.set_x(0);
			}
			break;
		case KeyEvent.VK_LEFT://����Ϊ�� �����Ϊ��
			if(dir.get_x()!=10) {
				dir.set_x(-10);
				dir.set_y(0);
			}
			break;
		case KeyEvent.VK_RIGHT://����Ϊ�� �����Ϊ��
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
