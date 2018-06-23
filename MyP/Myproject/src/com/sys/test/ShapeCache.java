package com.sys.test;

import java.util.Hashtable;

public class ShapeCache {
	
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
	
	public static Shape getShape(String shapeId){
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}
	
	//��ÿ����״���������ݿ��ѯ����������״
	
	public static void loadCache(){
		Rectangle rectangle = new Rectangle();
		shapeMap.put("id1", rectangle);
		
		Square square = new Square();
		shapeMap.put("id2", square);
	}
	

}
