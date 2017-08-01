package com.qys.boring;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
	ArrayList<Point> _snakeList= new ArrayList<Point>();
	
	{
		_initSnake();
	}
	
	private void _initSnake() {
		Random random = new Random();
		Point p = new Point();
		p.set_x(random.nextInt(39)*10);
		p.set_y(random.nextInt(39)*10);
		_snakeList.add(p);
	}

	public ArrayList<Point> get_snakeList() {
		return _snakeList;
	}

	public void set_snakeList(ArrayList<Point> _snakeList) {
		this._snakeList = _snakeList;
	}
	
	

}
