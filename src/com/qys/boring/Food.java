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
		foodPoint.set_x(random.nextInt(40)*10);
		foodPoint.set_y(random.nextInt(40)*10);
	}


	public static void resertPoint() {
		Random random = new Random();
		foodPoint.set_x(random.nextInt(40)*10);
		foodPoint.set_y(random.nextInt(40)*10);
	}
	
	
	public static Point getFoodPoint() {
		return foodPoint;
	}


	public static void setFoodPoint(Point foodPoint) {
		Food.foodPoint = foodPoint;
	}
	

	
}
