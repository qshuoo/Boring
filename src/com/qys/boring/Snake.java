package com.qys.boring;

import java.util.LinkedList;
import java.util.Random;

public class Snake {
	private static LinkedList<Point> _snakeList;// ��������

	private static Point direction;// ��ǰ������

	{
		_snakeList = new LinkedList<Point>();
		direction = new Point();
		_initSnake();
		_initDirection();
	}

	private void _initSnake() {
		Random random = new Random();
		Point p = new Point();
		p.set_x((random.nextInt(38)+1) * 10);
		p.set_y((random.nextInt(38)+1) * 10);
		
		_snakeList.add(p);
		
		//Obstacle.addPoint(p);

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
		
		direction.set_x(x);
		direction.set_y(y);
	}

	public static LinkedList<Point> get_snakeList() {
		return _snakeList;
	}

	public void set_snakeList(LinkedList<Point> _snakeList) {
		Snake._snakeList = _snakeList;
	}

	
	//�ƶ�
	public void move() {
		Point head = _snakeList.get(0);
		Point newHead = new Point(head.get_x() + direction.get_x(), head.get_y() + direction.get_y());
		
		
		Obstacle.addPoint(head);
		_snakeList.addFirst(newHead);
		
		
		
		Obstacle.removePoint(_snakeList.getLast());
		_snakeList.removeLast();
		
		
	}
	
	
	//��
	public void eat(Point p ) {
		Point newP = new Point();
		newP.set_x(p.get_x());
		newP.set_y(p.get_y());
		Obstacle.addPoint(_snakeList.getFirst());
		_snakeList.addFirst(newP);
		
//		Obstacle.removePoint(newP);
	}
	
	//��ȡ��һλ��
	public Point getNext() {
		Point head = _snakeList.get(0);
		return new Point(head.get_x() + direction.get_x(), head.get_y() + direction.get_y());
	}
	//��ȡ����
	public static Point getDirection() {
		return direction;
	}
	//���÷���
	public static void setDirection(Point direction) {
		Snake.direction = direction;
	}

}
