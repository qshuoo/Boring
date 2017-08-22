package com.qys.boring2;

import java.util.Random;

// ≥ŒÔ¿‡
public class Food {
	private Point foodPoint;

	{
		foodPoint = new Point();
		init();
	}

	private void init() {
		Random random = new Random();
		foodPoint.setX((random.nextInt(38) + 1) * 10);
		foodPoint.setY((random.nextInt(38) + 1) * 10);
	}

	public void resetPoint() {
		Random random = new Random();
		int x = random.nextInt(38) + 1;
		int y = random.nextInt(38) + 1;

		foodPoint.setX(x * 10);
		foodPoint.setY(y * 10);
	}

	public Point getFoodPoint() {
		return foodPoint;
	}

	public void setFoodPoint(Point foodPoint) {
		this.foodPoint = foodPoint;
	}

}
