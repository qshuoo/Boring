package com.qys.boring;

public class SnakeTd extends Thread {

	SnakePrint snakePrint;
	private String control ="";

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
		System.out.println("123");
//		System.out.println(SnakePrint.gameEnd);
//		if(SnakePrint.gameStart) {
//			control.notify();
//		}
		while (!SnakePrint.gameEnd) {
			synchronized (control) {
				if (SnakePrint.gameStart) {
					snakePrint.repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}/* else {
					try {
						control.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}*/
			}
		}

	}

}
