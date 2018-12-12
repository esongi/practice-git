package com.bitcamp.day3;

public class Triangle extends Shape {

	private Point[] pointarray;

	public Triangle() {
		this(new Point[] { new Point(1, 2), new Point(3, 4), new Point(5, 6) });
	}

	public Triangle(Point[] pointarray) {
		this.pointarray = pointarray;
	}

	public void triangePoint() {
		for (Point point : pointarray) {
			System.out.println("좌표: " + point.x + "," + point.y);
		}
	}
}
