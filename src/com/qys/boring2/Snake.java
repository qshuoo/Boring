package com.qys.boring2;

import java.util.LinkedList;
import java.util.Random;


public class Snake {

	private LinkedList<Point> snakeList;// ��������

	private static Point direction;// ��ǰ������

	{
		snakeList = new LinkedList<Point>();
		direction = new Point();
		_initSnake();
		_initDirection();
	}

	private void _initSnake() {
		Random random = new Random();
		Point p = new Point();
		p.setX((random.nextInt(38) + 1) * 10);
		p.setY((random.nextInt(38) + 1) * 10);
		snakeList.add(p);
	}

	private void _initDirection() {
		Random random = new Random();
		int num = random.nextInt(4);
		int x = 0;
		int y = 0;
		switch (num) {
		case 0:
			y = -10;
			break;
		case 1:
			y = 10;
			break;
		case 2:
			x = -10;
			break;
		case 3:
			x = 10;
			break;
		default:
			break;
		}
		direction.setX(x);
		direction.setY(y);
	}

	public LinkedList<Point> getsnakeList() {
		return this.snakeList;
	}

	public void setsnakeList(LinkedList<Point> snakeList) {
		this.snakeList = snakeList;
	}

	// �ƶ�
	public void move() {
		Point head = snakeList.get(0);
		Point newHead = new Point(head.getX() + direction.getX(), head.getY() + direction.getY());
		snakeList.addFirst(newHead);
		snakeList.removeLast();

	}

	// ��
	public void eat(Point p) {
		Point newP = new Point();
		newP.setX(p.getX());
		newP.setY(p.getY());
		snakeList.addFirst(newP);

	}

	// ��ȡ��һλ��
	public Point getNext() {
		Point head = snakeList.get(0);
		return new Point(head.getX() + direction.getX(), head.getY() + direction.getY());
	}

	// ��ȡ����
	public static Point getDirection() {
		return direction;
	}

	// ���÷���
	public static void setDirection(Point direction) {
		Snake.direction = direction;
	}
}
