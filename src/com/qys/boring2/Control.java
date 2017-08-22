package com.qys.boring2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Control implements KeyListener{
	Point dir = Snake.getDirection();
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP://方向不为下 方向改为上
			if(dir.getY()!=10) {
				dir.setY(-10);
				dir.setX(0);
			}
			break;
		case KeyEvent.VK_DOWN://方向不为上 方向改为下
			if(dir.getY()!=-10) {
				dir.setY(10);
				dir.setX(0);
			}
			break;
		case KeyEvent.VK_LEFT://方向不为右 方向改为左
			if(dir.getX()!=10) {
				dir.setX(-10);
				dir.setY(0);
			}
			break;
		case KeyEvent.VK_RIGHT://方向不为左 方向改为右
			if(dir.getX()!=-10) {
				dir.setX(10);
				dir.setY(0);
			}
		default:
			break;
		}
		
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
