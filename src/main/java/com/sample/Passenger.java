package com.sample;


public class Passenger {
	
	private String name;
	private Integer income = 100;
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public Integer getIncome(){
		return income;
	}
	
	public void setIncome(Integer income){
		this.income = income;
	}
}