package com.qys.boring;

import java.util.Random;

// ≥ŒÔ¿‡
public class Food {
	private static Point foodPoint;
	
	{
		foodPoint = new Point();
		init();
	}
	
	
	private  void init() {
		Random random = new Random();
		foodPoint.set_x((random.nextInt(38)+1)*10);
		foodPoint.set_y((random.nextInt(38)+1)*10);
	}


	public static void resertPoint() {
		Random random = new Random();
		int x= random.nextInt(38)+1;
		int y= random.nextInt(38)+1;
		if(Obstacle.getarrayNum(x, y)==1) {
			resertPoint();
		}else {
		foodPoint.set_x(x*10);
		foodPoint.set_y(y*10);
		}
	}
	
	
	public static Point getFoodPoint() {
		return foodPoint;
	}


	public static void setFoodPoint(Point foodPoint) {
		Food.foodPoint = foodPoint;
	}
	

	
}
