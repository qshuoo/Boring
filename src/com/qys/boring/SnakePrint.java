package com.qys.boring;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * �滭��Ϸ����
 * @author Administrator
 *
 */
public class SnakePrint extends JPanel{
	
	private JButton _startButton;//��ʼ��ť
	
	public SnakePrint() {
		_initButton();
	}
	
	private void _initButton() {
		this.setLayout(null);
		
		//��ʼ��Ϸ��ť
		_startButton = new JButton();
		_startButton.setText("��ʼ��Ϸ");
		_startButton.setLocation(420, 250);
		_startButton.setSize(90, 30);
		this.add(_startButton);
		
		this.requestFocus();
		
	}

}
