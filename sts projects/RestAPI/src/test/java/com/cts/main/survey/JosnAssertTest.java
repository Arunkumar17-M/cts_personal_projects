package com.cts.main.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JosnAssertTest {
	
	@Test
	public void JsonAssert_BasicsLearning() throws JSONException{
		
		String expected =
			"{\"id\":\"Question1\","
			+ "\"description\":\"Most Popular Cloud Platform Today\","
			+ "\"correctAnswer\":\"AWS\"}";
		
		String actual =
			"{\"id\":\"Question1\","
			+ "\"description\":\"Most Popular Cloud Platform Today\","
			+ "\"options\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Oracle Cloud\"],"
			+ "\"correctAnswer\":\"AWS\"}";
		
		JSONAssert.assertEquals(expected, actual, false);
		// strict in last parameter is true for exact actual
		// but if we change false then one key and value not be there but also check and give green signal.
	}

}
