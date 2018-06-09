package com.huhao.springboot.pojo;

public class PojoPage<T> {
	
	private int start ;
	
	private int size;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start<0?0:start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	

}
