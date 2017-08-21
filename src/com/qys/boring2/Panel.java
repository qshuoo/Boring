package com.qys.boring2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;



public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 背景大小
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	//模拟点的大小
	private final int _tileSize = 10;
	
	private Snake snake;
	public Panel() {
		snake = new Snake();
	}

	// 画组件
	@Override
	public void paintComponent(Graphics pen) {
		creatGameInit(pen);
		printSnake(pen);
		this.requestFocus();
	}

	// 画背景
	private void creatGameInit(Graphics pen) {
		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);

	}
	
	private void printSnake(Graphics pen) {
		for (Point p : snake.getsnakeList()) {
			pen.setColor(Color.BLUE);
			pen.fillRect(p.getX(), p.getY(), _tileSize, _tileSize);
		}
	}

}
