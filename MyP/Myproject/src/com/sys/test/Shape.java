package com.sys.test;

public abstract class Shape implements Cloneable{
	
	String type; 
	
	String color;
	
	abstract void draw();

	@Override
	protected Object clone() {
		// TODO Auto-generated method stub
		Object clone = null;
		try {
			clone = super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return clone;
	}
	
	

}
