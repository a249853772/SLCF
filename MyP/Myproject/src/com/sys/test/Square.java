package com.sys.test;

public class Square extends Shape {
	public Square() {
		// TODO Auto-generated constructor stub
		this.color = "Blue";
		this.type = "Square";
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("draw "+color+" "+type);
	}

}
