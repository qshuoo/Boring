package com.qys.boring;

/**
 * �ϰ����� ����ǽ ������
 * @author Administrator
 *
 */

public class Obstacle {
	static int[][] ob = new int[40][40];
	
	static{
		init();
	}
	public static void init() {
		for(int i=0;i<40;i++) {
			ob[0][i] = 1;
			ob[39][i] = 1;
			ob[i][0] =1;
			ob[i][39] =1;
		}
	}
	

}
