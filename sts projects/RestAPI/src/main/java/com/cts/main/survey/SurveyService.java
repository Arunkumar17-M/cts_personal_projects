package com.cts.main.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey surveybyId(String surveyId) {

		Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
		if (optionalSurvey.isEmpty())
			return null;
		return optionalSurvey.get();
//		for(Survey survey: surveys) {
//			if(survey.getId().equals(surveyId)) return survey;
//		}
//		return null;
	}

	public List<Question> retrieveAllSurveyQuestions(String surveyId) {
		
		Survey survey= surveybyId(surveyId);
		if(survey==null) return null;
		return survey.getQuestions();
	}

	public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {
		
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		if(questions.isEmpty()) return null;
		
		Optional<Question> optionalquestion=questions.stream()
				.filter(q -> q.getId().equalsIgnoreCase(questionId)).findFirst();
		if(optionalquestion.isEmpty()) return null;
		
		return optionalquestion.get();
	}

	public String addNewSurveyQuetions(String surveyId, Question question) {

		// List<Question> questions = new ArrayList<>(retrieveAllSurveyQuestions(surveyId))
		//above line will not affect the original survey list but below line is connected to survey
		// that's why the change in questions reflecting the original survey.
		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		question.setId(getSecureRandomId());
		questions.add(question);
		return question.getId();
	}
	
	public String deleteSurveyQuestion(String surveyId, String questionId) {
		
		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		List<Question> surveyQuestions = retrieveAllSurveyQuestions(surveyId);
		if(surveyQuestions == null) return null;
		
		boolean removed = surveyQuestions.removeIf(predicate);
		
		if(!removed) return null;
		
		return questionId;
	}
	
	public String getSecureRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String random = new BigInteger(32, secureRandom).toString();
		return random;
	}

	public String updateSurveyQuestion(String surveyId, String questionId, Question question) {

		List<Question> questions = retrieveAllSurveyQuestions(surveyId);
		if(questions.isEmpty()) return null;
		boolean removed = questions.removeIf(q -> q.getId().equals(questionId));
		if(!removed) return null;
		questions.add(question);
		return questionId;
	}
}
