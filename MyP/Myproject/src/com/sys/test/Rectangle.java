package com.sys.test;

public class Rectangle extends Shape{
	
	Rectangle(){
		this.type = "Rectangle";
		this.color = "Red";
		
	}

	@Override
	void draw() {
		// TODO Auto-generated method stub
		System.out.println("draw "+color+" "+type);
	}

}
