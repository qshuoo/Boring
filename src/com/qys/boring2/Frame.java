package com.qys.boring2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	// 每个Frame都有一个id
	private static final long serialVersionUID = 1L;
	// Frame 窗口大小
	private final int _windowWidth = 410;
	private final int _windowHeight = 430;

	public Frame() {
		this.setTitle("第一個版本");
		this.setSize(_windowWidth, _windowHeight);
		// 获取屏幕大小
		Toolkit _toolKit = Toolkit.getDefaultToolkit();
		Dimension _screenSize = _toolKit.getScreenSize();
		final int _screenWidth = _screenSize.width;
		final int _screenHeight = _screenSize.height;
		// 计算居中
		this.setLocation((_screenWidth - this.getWidth()) / 2, (_screenHeight - this.getHeight()) / 2);
		// 默认无关闭操作
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 设置窗口不变
		this.setResizable(false);
		// 设置可见
		this.setVisible(true);
		// 暂时不用布局方式
		this.setLayout(null);
	}
}
