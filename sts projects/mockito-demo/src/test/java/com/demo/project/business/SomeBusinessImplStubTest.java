package com.demo.project.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findTheGreatestFromAllData_BasicScenario() {
		
		DataService dataService = new DataServiceStub1();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}
	
	@Test
	void findTheGreatestFromAllDataOneValue() {
		
		DataService dataService = new DataServiceStub2();
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataService);
		int result = businessImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}

}

class DataServiceStub1 implements DataService{

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {25, 6, 10};
	}
	
}

class DataServiceStub2 implements DataService{

	@Override
	public int[] retrieveAllData() {
		
		return new int[] {25};
	}
	
}