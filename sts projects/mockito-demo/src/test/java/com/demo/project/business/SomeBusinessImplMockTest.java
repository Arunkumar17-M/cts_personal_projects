package com.demo.project.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//To use mock below statement is needed
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock
	private DataService dataService;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findTheGreatestFromAllData_BasicScenario() {
		
		when(dataService.retrieveAllData()).thenReturn(new int[] {25,4,24});
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllDataOneValue() {
		
		when(dataService.retrieveAllData()).thenReturn(new int[] {25});
		assertEquals(25, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllDataEmptyArray() {
		
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}

}
