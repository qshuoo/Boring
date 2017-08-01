package com.qys.boring;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * ���ô��ڵĸ�ʽ
 * @author Administrator
 *
 */

public class FrameClient extends JFrame{
	//ÿ��Frame����һ��id
	private static final long serialVersionUID = 1L;
	//Frame ���ڴ�С
	private final int _windowWidth = 530;
	private final int _windowHeight = 450;
	public FrameClient() {
		this.setTitle("��һ�γ���");
		this.setSize(_windowWidth, _windowHeight);
		//��ȡ��Ļ��С
		Toolkit _toolKit = Toolkit.getDefaultToolkit();
		Dimension _screenSize = _toolKit.getScreenSize();
		final int _screenWidth = _screenSize.width;
		final int _screenHeight = _screenSize.height;
		//�������
		this.setLocation((_screenWidth-this.getWidth())/2,(_screenHeight-this.getHeight())/2);
		//Ĭ���޹رղ���
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��ڲ���
		this.setResizable(false);
		//���ÿɼ�
		this.setVisible(true);
		//��ʱ���ò��ַ�ʽ
		this.setLayout(null);
		
	}
}