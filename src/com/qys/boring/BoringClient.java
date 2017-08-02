package com.qys.boring;

public class BoringClient implements Runnable{
	public static void main(String[] args) {
		FrameClient frameClient = new FrameClient();
		SnakePrint snakePrint = new SnakePrint();
		
		frameClient.setContentPane(snakePrint);
		while(true) {
			snakePrint.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
