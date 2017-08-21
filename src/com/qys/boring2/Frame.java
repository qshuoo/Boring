package com.qys.boring2;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame {

	// ÿ��Frame����һ��id
	private static final long serialVersionUID = 1L;
	// Frame ���ڴ�С
	private final int _windowWidth = 410;
	private final int _windowHeight = 430;

	public Frame() {
		this.setTitle("��һ���汾");
		this.setSize(_windowWidth, _windowHeight);
		// ��ȡ��Ļ��С
		Toolkit _toolKit = Toolkit.getDefaultToolkit();
		Dimension _screenSize = _toolKit.getScreenSize();
		final int _screenWidth = _screenSize.width;
		final int _screenHeight = _screenSize.height;
		// �������
		this.setLocation((_screenWidth - this.getWidth()) / 2, (_screenHeight - this.getHeight()) / 2);
		// Ĭ���޹رղ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ���ô��ڲ���
		this.setResizable(false);
		// ���ÿɼ�
		this.setVisible(true);
		// ��ʱ���ò��ַ�ʽ
		this.setLayout(null);
	}
}
