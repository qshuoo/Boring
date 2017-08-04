package com.qys.boring;

public class BoringClient {
	public static void main(String[] args) {
		FrameClient frameClient = new FrameClient();
		SnakePrint snakePrint = new SnakePrint();
		frameClient.setContentPane(snakePrint);
		SnakeTd snakeTd = new SnakeTd(snakePrint);
		snakeTd.start();
//		while(true) {
//			snakePrint.repaint();
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	}

}
