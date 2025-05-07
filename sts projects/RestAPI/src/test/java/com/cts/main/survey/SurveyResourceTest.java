package com.cts.main.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Base64;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.main.user.UserDetailsRepository;

//SurveyResource
@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters = false)
class SurveyResourceTest {

	// Mock -> surveyService.retrieveSpecificSurveyQuestion(surveyId, questionId)
	// Fire a request
	/// surveys/{surveyId}/questions/{questionId}
	// http://localhost:9090/surveys/Survey1/questions/Question1 GET

	@MockBean
	private SurveyService surveyService;
	
	@MockBean
	private UserDetailsRepository repo;
	// above statement is dependence to the surveyResource class so we have to mock
	// this bean
	// this the error: No qualifying bean of type
	// 'com.cts.main.survey.SurveyService' available

	// To fire the request
	@Autowired
	private MockMvc mockMvc;

	private static String SPECIFIC_QUESTION_URL = "http://localhost:9090/surveys/Survey1/questions/Question1";
	
	private static String GENERIC_QUESTIONS_URL = "/surveys/Survey1/questions/";

	@Test
	void retrieveSpecificSurveyQuetion_404Scenario() throws Exception {
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(404, mvcResult.getResponse().getStatus());
		
//		System.out.println(mvcResult.getResponse().getStatus());
//		System.out.println(mvcResult.getResponse().getContentAsString());
		
	}
		
	@Test
	void retrieveSpecificSurveyQuetion_basicScenario() throws Exception {
		
		RequestBuilder requestBuilder = 
				MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL).accept(MediaType.APPLICATION_JSON);
		
		String expectedResponse = "{\"id\":\"Question1\","
				+ "\"description\":\"Most Popular Cloud Platform Today\","
				+ "\"options\":[\"AWS\",\"Azure\",\"Google Cloud\",\"Oracle Cloud\"],"
				+ "\"correctAnswer\":\"AWS\"}";
		
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		
		when(surveyService.retrieveSpecificSurveyQuestion("Survey1", "Question1")).thenReturn(question1);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
		
	}
	
	//addNewSurvey
	//POST
	//201
	//http://localhost:9090/surveys/Survey1/questions
	//Location: http://localhost:9090/surveys/Survey1/questions/124214
	
	@Test
	void addNewSurvey() throws Exception {
		
		when(surveyService.addNewSurveyQuetions(anyString(), any())).thenReturn("Some_ID");
		String expectedResponse =
				"{"
						+ "\"description\":\"Most Popular Platform Today\","
						+"\"options\":[\"Java\",\"Python\",\"Machine Learning\",\"C++\"],"
						+ "\"correctAnswer\":\"Java\"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(GENERIC_QUESTIONS_URL)
				.accept(MediaType.APPLICATION_JSON).content(expectedResponse).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(201, mvcResult.getResponse().getStatus());
		
		String locationHeader = mvcResult.getResponse().getHeader("Location");
		assertTrue(locationHeader.contains("/surveys/Survey1/questions/Some_ID"));
	}
	
}
