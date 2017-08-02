package com.qys.boring;

public class BoringTest {
	public static void main(String[] args) {
		System.out.println("This is a test");
		System.out.println("find ways");
//		Obstacle o = new Obstacle();
		for(int i=0;i<40;i++) {
			for(int j=0;j<40;j++) {
				System.out.print(Obstacle.ob[i][j] + " ");
			}
			System.out.println();
		}
	}

}
