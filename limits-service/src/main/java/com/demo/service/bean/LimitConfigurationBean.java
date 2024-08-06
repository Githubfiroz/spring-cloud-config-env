package com.demo.service.bean;

public class LimitConfigurationBean {

	private int maximum;
	private int minimum;
		
	//No-argument constructor
	protected LimitConfigurationBean() {
		
	}
	
	//Getters
	public int getMaximum() {
		return maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	
	//constructor using fields
	public LimitConfigurationBean(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}
	
}
