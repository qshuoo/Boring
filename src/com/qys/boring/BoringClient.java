package com.qys.boring;

public class BoringClient {
	public static void main(String[] args) {
		FrameClient frameClient = new FrameClient();
		SnakePrint snakePrint = new SnakePrint();
		
		frameClient.setContentPane(snakePrint);
	}

}
