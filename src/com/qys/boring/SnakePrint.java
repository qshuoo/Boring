package com.qys.boring;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * �滭��Ϸ����
 * 
 * @author Administrator
 *
 */
public class SnakePrint extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton _startButton;// ��ʼ��ť
	//�����С
	private final int _x = 0;
	private final int _y = 0;
	private final int _panelWidth = 400;
	private final int _panelHeight = 400;
	//������
	private final int _tileSize = 10;
	
	Snake snake ;
	Obstacle obstacle;
	Food food;
	
	
	public SnakePrint() {
		snake = new Snake();
		obstacle = new Obstacle();
		food = new Food();
		_initButton();
	}

	// ��ť����
	private void _initButton() {
		this.setLayout(null);

		// ��ʼ��Ϸ��ť
		_startButton = new JButton();
		_startButton.setText("��ʼ��Ϸ");
		_startButton.setLocation(420, 250);
		_startButton.setSize(90, 30);
		this.add(_startButton);

		this.requestFocus();

	}

	// ���M��
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		_creatGameInit(pen);
		_createSnake(pen);
		_createFood(pen);
		_moveSnake();
		setGameControl(new SnakeControl());
//		snake.move();
		 System.out.println(Snake.get_snakeList());
		 System.out.println(Snake.getDirection());
		this.requestFocus();
	}

	// ���W��

	private void _creatGameInit(Graphics pen) {
		
		//������
		pen.setColor(Color.WHITE);
		pen.fillRect(_x + 1, _y + 1, _panelWidth - 1, _panelHeight - 1);
		//����
		pen.setColor(Color.GRAY);
		for (int i = 1; i < this._panelWidth / this._tileSize; i++) {
			pen.drawLine(this._x + i * _tileSize, this._y, this._x + i * _tileSize, this._y + this._panelHeight);
		}

		for (int i = 1; i < this._panelHeight / this._tileSize; ++i) {
			pen.drawLine(this._x, this._y + i * this._tileSize, this._x + this._panelWidth,
					this._y + i * this._tileSize);
		}
		//���߿�
		
		pen.setColor(Color.BLACK);
		pen.drawRect(_x, _y, _panelWidth, _panelHeight);
//		pen.fillRect(_x, _y, _panelWidth, _tileSize);
//		pen.fillRect(_x, _y, _tileSize, _panelHeight);
//		pen.fillRect(_x, _panelHeight-_tileSize, _panelWidth, _tileSize);
//		pen.fillRect(_panelWidth-_tileSize, _y, _tileSize, _panelHeight);
		
	}

	// ����
	private void _createSnake(Graphics pen) {
		
		for (Point p : Snake.get_snakeList()) {
			pen.setColor(Color.BLUE);
			pen.fillRect(p.get_x(), p.get_y(), _tileSize, _tileSize);
		}

	}
	//��ʳ��
	
	private void _createFood(Graphics pen) {
		pen.setColor(Color.RED);
		pen.fillRect(Food.getFoodPoint().get_x(), Food.getFoodPoint().get_y(), _tileSize, _tileSize);
	}
	
	//���ƶ��ж�
	private void _moveSnake() {
		if(!_crashJudge())
			snake.move();
	}
	
	//����ײ�ж�
	private boolean _crashJudge() {
		Point p = Snake.get_snakeList().get(0);
		if(obstacle.getPointNum(p)==1)
			return true;
		return false;
	}

	// ������
	public void setGameControl(SnakeControl control) {
		this.addKeyListener(control);
	}

}
