package com.sg.Trivia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sg.Trivia.Models.Quiz;

import com.sg.Trivia.data.QuizDao;

@RestController
public class MainController {

	private final QuizDao dao;

	public MainController(QuizDao dao) {
		this.dao = dao;
	}

	@CrossOrigin
	@GetMapping("/getQuizzes")
	public List<Quiz> all() {
		return dao.getAllQuiz();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable int id) {
		Quiz result = dao.getQuizbyId(id);
		if (result == null) {
			return new ResponseEntity(null, HttpStatus.NOT_FOUND);
		}
		System.out.println("Test 22222");
		return ResponseEntity.ok(result);
	}

	@CrossOrigin
	@PostMapping("/addQuiz")
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz create(@RequestBody Quiz quiz) {
		System.out.println("Test");
		return dao.addQuiz(quiz);
	}

}
//createuser
//deleteuser
//calculatestatistics
//getquiz
//answerquiz or /postquiz