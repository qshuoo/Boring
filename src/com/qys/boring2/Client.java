package com.qys.boring2;

public class Client {
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		Panel panel = new Panel();
		frame.setContentPane(panel);
		
		while(true) {
			try {
				Thread.sleep(200);
				panel.repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
