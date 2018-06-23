package com.sys.test;

public class PrototypePatternDemo {
	
	public static void main(String[] args) {
		ShapeCache.loadCache();
		
		Shape clonedShape = ShapeCache.getShape("id1");
		clonedShape.draw();
		
		Shape cloneShape2 = ShapeCache.getShape("id2");
		cloneShape2.draw();
	}

}
