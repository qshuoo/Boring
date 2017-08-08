package com.qys.boring;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * 绘画游戏画面
 * 
 * @author Administrator
 *
 */
public class SnakePrint extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _startButton;// 开始按钮
	// 网格大小
	private JButton _scoreButton;
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	// 网格间隔
	private final int _tileSize = 10;
	// 遊戲進程是否開始
	private boolean isRunning = false;
	// 游戏开始结束进程
	private Thread snakeTd;
	
	// 内部对象
	private Snake snake;
	private Food food;
	// 得分
	private int count;
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
		
		_scoreButton = new JButton();
		_scoreButton.setText("得分："+Integer.toString(count));
		_scoreButton.setLocation(420, 100);
		_scoreButton.setSize(90, 30);
		this.add(_scoreButton);
		this.requestFocus();

	}

	// 畫組件
	@Override
	public void paintComponent(Graphics pen) {
//		super.paintComponent(pen);
		_creatGameInit(pen);
		_buttonJudge();
		if (isRunning) {
			_createSnake(pen);
			_createFood(pen);
			_moveSnake();
			setGameControl(new SnakeControl());
			_crashJudge();
		}
		this.requestFocus();
	}

	// 畫網格

	private void _creatGameInit(Graphics pen) {

		// 画背景
		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);
		// 画线
		pen.setColor(Color.GRAY);
		for (int i = 1; i < this._panelWidth / this._tileSize; i++) {
			pen.drawLine(this._x + i * _tileSize, this._y, this._x + i * _tileSize, this._y + this._panelHeight);
		}

		for (int i = 1; i < this._panelHeight / this._tileSize; ++i) {
			pen.drawLine(this._x, this._y + i * this._tileSize, this._x + this._panelWidth,
					this._y + i * this._tileSize);
		}
		// 画边框

		pen.setColor(Color.gray);
		pen.drawRect(_x, _y, _panelWidth, _panelHeight);
		pen.fillRect(_x, _y, _panelWidth, _tileSize);
		pen.fillRect(_x, _y, _tileSize, _panelHeight);
		pen.fillRect(_x, _panelHeight - _tileSize, _panelWidth, _tileSize);
		pen.fillRect(_panelWidth - _tileSize, _y, _tileSize, _panelHeight);

	}

	// 画蛇
	private void _createSnake(Graphics pen) {

		for (Point p : snake.get_snakeList()) {
			pen.setColor(Color.BLUE);
			if (p == snake.get_snakeList().getFirst())
				pen.setColor(Color.GREEN);
			pen.fillRect(p.get_x() + 1, p.get_y() + 1, _tileSize - 1, _tileSize - 1);
		}

	}
	// 画食物

	private void _createFood(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(food.getFoodPoint().get_x(), food.getFoodPoint().get_y(), _tileSize, _tileSize);
	}

	// 蛇移动判定
	private void _moveSnake() {
		if (_eatJudge()) {
			snake.eat(food.getFoodPoint());
			food.resertPoint();
		} else
			snake.move();
	}

	// 蛇碰撞判定
	private boolean _crashJudge() {
		Point p = snake.get_snakeList().get(0);

		if (Obstacle.getPointNum(p) == 1) {
			_gameEnd();
			return true;
		}
		return false;
	}

	//遊戲結束
	@SuppressWarnings("deprecation")
	private void _gameEnd() {
		_scoreButton.setText("游戏结束");
		snakeTd.stop();
		isRunning = false;
		snake = null;
		food = null;

	}
	// 蛇吃食物判定

	private boolean _eatJudge() {
		if (snake.getNext().equals(food.getFoodPoint())) {
			count++;
			_scoreButton.setText("得分："+Integer.toString(count));
			return true;
		}
		return false;
	}

	// 开始按钮点击判定
	public void _buttonJudge() {
		
		_startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!isRunning) {
					count = 0;
					_scoreButton.setText("得分："+Integer.toString(count));
					snake = new Snake();
					food = new Food();
					isRunning = true;
					snakeTd = new Thread(new SnakeTd(SnakePrint.this));
					snakeTd.start();
				}
			}

		});

	}

	// 控制器
	public void setGameControl(SnakeControl control) {
		this.addKeyListener(control);
	}

}
