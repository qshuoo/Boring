package com.qys.boring2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Control implements KeyListener{
	Point dir = Snake.getDirection();
	
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()) {
		case KeyEvent.VK_UP://����Ϊ�� �����Ϊ��
			if(dir.getY()!=10) {
				dir.setY(-10);
				dir.setX(0);
			}
			break;
		case KeyEvent.VK_DOWN://����Ϊ�� �����Ϊ��
			if(dir.getY()!=-10) {
				dir.setY(10);
				dir.setX(0);
			}
			break;
		case KeyEvent.VK_LEFT://����Ϊ�� �����Ϊ��
			if(dir.getX()!=10) {
				dir.setX(-10);
				dir.setY(0);
			}
			break;
		case KeyEvent.VK_RIGHT://����Ϊ�� �����Ϊ��
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
