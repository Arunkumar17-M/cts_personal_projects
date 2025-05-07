package com.demo.project.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {
	
	@Test
	public void sizeTest() {
		
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(3);
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void multipleValueTest() {
		
		List listMock = mock(List.class);
		
		when(listMock.size()).thenReturn(3).thenReturn(2);
		assertEquals(3, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void specificParameterTest() {
		
		List listMock = mock(List.class);
		
		when(listMock.get(0)).thenReturn("SomeThingReturn");
		assertEquals("SomeThingReturn", listMock.get(0));
		assertEquals(null, listMock.get(1));
		assertEquals(null, listMock.get(2));
	}
	
	@Test
	public void genericParameterTest() {
		
		List listMock = mock(List.class);
		
		when(listMock.get(Mockito.anyInt())).thenReturn("SomeThingReturn");
		assertEquals("SomeThingReturn", listMock.get(0));
		assertEquals("SomeThingReturn", listMock.get(1));
	}
}
