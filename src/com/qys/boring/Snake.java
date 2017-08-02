package com.qys.boring;

import java.util.LinkedList;
import java.util.Random;

public class Snake {
	private static LinkedList<Point> _snakeList;//蛇身链表
	
	private static Point direction;//蛇前进方向
	
	{
		_snakeList= new LinkedList<Point>();
		_initSnake();
	}
	
	private void _initSnake() {
		Random random = new Random();
		Point p = new Point();
		p.set_x(random.nextInt(39)*10);
		p.set_y(random.nextInt(39)*10);
		_snakeList.add(p);
	}

	public static LinkedList<Point> get_snakeList() {
		return _snakeList;
	}

	public void set_snakeList(LinkedList<Point> _snakeList) {
		Snake._snakeList = _snakeList;
	}
	
	public void move(Point dir) {
		Point head = _snakeList.get(0);
		Point newHead = new Point(head.get_x()+dir.get_x(),head.get_y()+dir.get_y());
	}
	

}
