package com.qys.boring;

public class BoringClient implements Runnable{
	public static void main(String[] args) {
		FrameClient frameClient = new FrameClient();
		SnakePrint snakePrint = new SnakePrint();
		
		frameClient.setContentPane(snakePrint);
		while(true) {
			snakePrint.repaint();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
