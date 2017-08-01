package com.qys.boring;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 绘画游戏画面
 * 
 * @author Administrator
 *
 */
public class SnakePrint extends JPanel {

	private JButton _startButton;// 开始按钮
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	private final int _tileSize = 10;

	public SnakePrint() {
		_initButton();
	}

	// 按钮布局
	private void _initButton() {
		this.setLayout(null);

		// 开始游戏按钮
		_startButton = new JButton();
		_startButton.setText("开始游戏");
		_startButton.setLocation(420, 250);
		_startButton.setSize(90, 30);
		this.add(_startButton);

		this.requestFocus();

	}

	// 畫組件
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		_creatGameInit(pen);
		_createSnake(pen);
		setGameControl(new SnakeControl());
		this.requestFocus();
	}

	// 畫網格

	private void _creatGameInit(Graphics pen) {
		pen.setColor(Color.BLACK);
		pen.drawRect(_x, _y, _panelWidth, _panelHeight);

		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);

		pen.setColor(Color.GRAY);
		for (int i = 1; i < this._panelWidth / this._tileSize; i++) {
			pen.drawLine(this._x + i * _tileSize, this._y, this._x + i * _tileSize, this._y + this._panelHeight);
		}

		for (int i = 1; i < this._panelHeight / this._tileSize; ++i) {
			pen.drawLine(this._x, this._y + i * this._tileSize, this._x + this._panelWidth,
					this._y + i * this._tileSize);
		}
	}

	// 画蛇
	private void _createSnake(Graphics pen) {
		Snake snake = new Snake();
		ArrayList<Point> _snakeList = snake.get_snakeList();

		for (Point p : _snakeList) {
			pen.setColor(Color.BLUE);
			pen.fillRect(p.get_x(), p.get_y(), _tileSize, _tileSize);
		}

	}

	// 控制器
	public void setGameControl(SnakeControl control) {
		this.addKeyListener(control);
	}

}
