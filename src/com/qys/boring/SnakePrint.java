package com.qys.boring;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	//网格大小
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	//网格间隔
	private final int _tileSize = 10;
	
	//游戏开始结束进程
	Thread snakeTd ;

	//内部对象
	Snake snake ;
	Obstacle obstacle;
	Food food;
	
	
	public SnakePrint() {
		snake = new Snake();
		obstacle = new Obstacle();
		food = new Food();
		snakeTd = new Thread(new SnakeTd(this));
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
		_createFood(pen);
		_buttonJudge();
		if(!_crashJudge())
			_moveSnake();
		setGameControl(new SnakeControl());
		this.requestFocus();
	}

	// 畫網格

	private void _creatGameInit(Graphics pen) {
		
		//画背景
		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);
		//画线
		pen.setColor(Color.GRAY);
		for (int i = 1; i < this._panelWidth / this._tileSize; i++) {
			pen.drawLine(this._x + i * _tileSize, this._y, this._x + i * _tileSize, this._y + this._panelHeight);
		}

		for (int i = 1; i < this._panelHeight / this._tileSize; ++i) {
			pen.drawLine(this._x, this._y + i * this._tileSize, this._x + this._panelWidth,
					this._y + i * this._tileSize);
		}
		//画边框
		
		pen.setColor(Color.gray);
		pen.drawRect(_x, _y, _panelWidth, _panelHeight);
		pen.fillRect(_x, _y, _panelWidth, _tileSize);
		pen.fillRect(_x, _y, _tileSize, _panelHeight);
		pen.fillRect(_x, _panelHeight-_tileSize, _panelWidth, _tileSize);
		pen.fillRect(_panelWidth-_tileSize, _y, _tileSize, _panelHeight);
		
	}

	// 画蛇
	private void _createSnake(Graphics pen) {
		
		for (Point p : Snake.get_snakeList()) {
			pen.setColor(Color.BLUE);
			if(p == Snake.get_snakeList().getFirst())
				pen.setColor(Color.GREEN);
			pen.fillRect(p.get_x()+1, p.get_y()+1, _tileSize-1, _tileSize-1);
		}

	}
	//画食物
	
	private void _createFood(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(Food.getFoodPoint().get_x(), Food.getFoodPoint().get_y(), _tileSize, _tileSize);
	}
	
	//蛇移动判定
	private void _moveSnake() {
		if(_eatJudge()) {
			snake.eat(Food.getFoodPoint());
			Food.resertPoint();
		}
		else 
			snake.move();
	}
	
	//蛇碰撞判定
	private boolean _crashJudge() {
		Point p = Snake.get_snakeList().get(0);
		
		if(obstacle.getPointNum(p)==1) {
			_gameEnd();
			return true;
			}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	private void _gameEnd() {
		Snake.get_snakeList().remove();
		snakeTd.stop();
		
	}
	

	//蛇吃食物判定
	
	private boolean _eatJudge() {
		if(snake.getNext().equals(Food.getFoodPoint()))
			return true;
		return false;
	}
	
	//开始按钮点击判定
	public void _buttonJudge() {
		_startButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				snakeTd.start();
				
			}
		});
	}
	
	// 控制器
	public void setGameControl(SnakeControl control) {
		this.addKeyListener(control);
	}

}
