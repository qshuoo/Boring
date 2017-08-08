package com.qys.boring;

public class SnakeTd implements Runnable {

	private SnakePrint snakePrint;
	public SnakeTd(SnakePrint snakePrint) {
		this.snakePrint = snakePrint;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			gameRunning();
		}
	}

	public void gameRunning() {
		snakePrint.repaint();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
