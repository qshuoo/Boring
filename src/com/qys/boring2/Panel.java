package com.qys.boring2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	// 背景大小
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;

	public Panel() {
	}

	// 画组件
	@Override
	public void paintComponent(Graphics pen) {
		_creatGameInit(pen);
		this.requestFocus();
	}

	// 画背景
	private void _creatGameInit(Graphics pen) {
		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);

	}

}
