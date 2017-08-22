package com.qys.boring2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	// ������С
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	// ģ���Ĵ�С
	private final int _tileSize = 10;

	private Snake snake;
	private Food food;

	public Panel() {
		snake = new Snake();
		food = new Food();
	}

	// �����
	@Override
	public void paintComponent(Graphics pen) {
		creatGameInit(pen);
		printSnake(pen);
		printFood(pen);
		moveSnake();
		this.addKeyListener(new Control());
		this.requestFocus();
	}

	// ������
	private void creatGameInit(Graphics pen) {
		pen.setColor(Color.WHITE);
		pen.fillRect(_x, _y, _panelWidth, _panelHeight);

	}

	// ����
	private void printSnake(Graphics pen) {
		pen.setColor(Color.BLUE);
		for (Point p : snake.getsnakeList()) {
			pen.fillRect(p.getX(), p.getY(), _tileSize, _tileSize);
		}
	}

	// �ƶ���
	private void moveSnake() {
		snake.move();
	}
	
	//��ʳ��
	private void printFood(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(food.getFoodPoint().getX(), food.getFoodPoint().getY(), _tileSize, _tileSize);
	}

}
