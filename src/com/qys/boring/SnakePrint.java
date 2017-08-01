package com.qys.boring;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 绘画游戏画面
 * @author Administrator
 *
 */
public class SnakePrint extends JPanel{
	
	private JButton _startButton;//开始按钮
	
	public SnakePrint() {
		_initButton();
	}
	
	private void _initButton() {
		this.setLayout(null);
		
		//开始游戏按钮
		_startButton = new JButton();
		_startButton.setText("开始游戏");
		_startButton.setLocation(420, 250);
		_startButton.setSize(90, 30);
		this.add(_startButton);
		
		this.requestFocus();
		
	}

}
