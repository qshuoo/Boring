package com.qys.boring;

public class Point {
	/**
	 * ×ø˜Ë
	 */
	private int _x;
	private int _y;
	public Point() {}
	public Point(int x,int y) {
		this._x = x;
		this._y = y;
	}
	public int get_x() {
		return _x;
	}
	public void set_x(int _x) {
		this._x = _x;
	}
	public int get_y() {
		return _y;
	}
	public void set_y(int _y) {
		this._y = _y;
	}
	@Override
	public String toString() {
		return "Point [_x=" + _x + ", _y=" + _y + "]";
	}
	
	

}
