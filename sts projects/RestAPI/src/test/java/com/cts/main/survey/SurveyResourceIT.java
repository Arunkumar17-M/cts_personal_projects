package com.cts.main.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//TestRestTemplate will not work if not add the above line
public class SurveyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";

	private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions/";

	@Autowired
	private TestRestTemplate template;

	/*
	 * String str = "{\"id\":\"Question1\"," +
	 * "\"description\":\"Most Popular Cloud Platform Today\"," +
	 * "\"options\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Oracle Cloud\"],\"correctAnswer\":\"AWS\"}"
	 * ;
	 */

	@Test
	public void retrieveSpecificSurveyQuetion_basicScenario() throws JSONException {

		HttpHeaders header = convertContentTypeAndAuthorizationHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
		ResponseEntity<String> responseEntity = template.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity,
				String.class);
		
//		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse = "{\"id\":\"Question1\"," + "\"description\":\"Most Popular Cloud Platform Today\","
				+ "\"options\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Oracle Cloud\"]," + "\"correctAnswer\":\"AWS\"}";

		// status response is it 200
		// [Contant-Type : "application/json"

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), true);

//		assertEquals(expectedResponse, entity.getBody());
//		System.out.println(entity.getBody());
//		System.out.println(entity.getHeaders());

	}

	@Test
	public void retrieveAllSurveyQuetion_basicScenario() throws JSONException {

		HttpHeaders header = convertContentTypeAndAuthorizationHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
		ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.GET, httpEntity,
				String.class);
		
//		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTIONS_URL, String.class);

		String expectedResponse = "[" + "  {" + "    \"id\": \"Question1\"" + "  }," + "  {"
				+ "    \"id\": \"Question2\"" + "  }," + "  {" + "    \"id\": \"Question3\"" + "  }" + "]";

		// status response is it 200
		// [Contant-Type : "application/json"

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

//		assertEquals(expectedResponse, entity.getBody());
//		System.out.println(entity.getBody());
//		System.out.println(entity.getHeaders());

	}

	@Test
	void addNewSurveyQuestion_basicScenario() {

		String expectedResponse = "{" + "\"description\":\"Most Popular Platform Today\","
				+ "\"options\":[\"Java\",\"Python\",\"Machine Learning\",\"C++\"]," + "\"correctAnswer\":\"Java\"}";

		// we have include the content type so httpheader is used
		HttpHeaders header = convertContentTypeAndAuthorizationHeaders();

		// responsebody to post, so HttpEntity with header and ResponseBody
		HttpEntity<String> httpEntity = new HttpEntity<>(expectedResponse, header);

		// template exchange method will post or get based on the parameter.
		ResponseEntity<String> responseEntity = template.exchange(GENERIC_QUESTIONS_URL, HttpMethod.POST, httpEntity,
				String.class);

		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getBody());

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/"));

		template.delete(locationHeader);

	}

	private HttpHeaders convertContentTypeAndAuthorizationHeaders() {
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json");
		header.add("Authorization", "Basic "+performBasicAuthEncoding("kumar", "password"));
		return header;
	}

	public String performBasicAuthEncoding(String username, String password) {

		String combined = username + ":" + password;
		byte[] encode = Base64.getEncoder().encode(combined.getBytes());
		return new String(encode);
	}
}
