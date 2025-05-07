package com.cts.main.survey;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	@Autowired
	SurveyService surveyService;

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}

	@RequestMapping("/surveys/{surveyId}")
	public Survey byid(@PathVariable String surveyId) {
		Survey survey = surveyService.surveybyId(surveyId);

		if (survey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return survey;
	}

	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuetions(@PathVariable String surveyId) {
		List<Question> questions = surveyService.retrieveAllSurveyQuestions(surveyId);

		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return questions;
	}

	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSpecificSurveyQuetion(@PathVariable String surveyId, @PathVariable String questionId) {
		Question question = surveyService.retrieveSpecificSurveyQuestion(surveyId, questionId);

		if (question == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return question;
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuetions(@PathVariable String surveyId, @RequestBody Question question) {
		String questionId = surveyService.addNewSurveyQuetions(surveyId, question);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSurveyQuetion(@PathVariable String surveyId, @PathVariable String questionId) {
		String deletedId = surveyService.deleteSurveyQuestion(surveyId, questionId);

		if (deletedId == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSurveyQuetion(@PathVariable String surveyId, @PathVariable String questionId,
			@RequestBody Question question) {
		String deletedId = surveyService.updateSurveyQuestion(surveyId, questionId, question);

		if (deletedId == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().build();
	}
}
