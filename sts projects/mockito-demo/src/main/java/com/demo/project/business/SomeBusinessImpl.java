package com.demo.project.business;

public class SomeBusinessImpl {

	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		this.dataService = dataService;
	}
	
	public int findTheGreatestFromAllData() {
		
		int[] data = dataService.retrieveAllData();
		int greatedValue = Integer.MIN_VALUE;
		for(int value : data) {
			if(value > greatedValue)
				greatedValue = value;
		}
		
		return greatedValue;
	}
}

interface DataService{
	
	public int[] retrieveAllData();
}