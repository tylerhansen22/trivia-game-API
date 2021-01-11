package com.sg.Trivia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.Trivia.Models.User;

@Controller
public class MainController {

	@PostMapping("/createuser")
	public void createUser(User user) {
		// [insert code to create user]
	}

	@PostMapping("/deleteuser")
	public void deleteUser(int userid) {
		// [insert code to create user]
	}

	@GetMapping("/getscore")
	public double getScore() {
		return 0;
		// [insert code to create user]
	}

	@PostMapping("/getaveragescore")
	public double getaveragescore() {
		return 0;
		// average of all quizs for that user
	}

	@PostMapping("/postquiz")//grabing quiz from front
	public void postquiz(int userid) {
		// [insert code to create user]
	}
	

}

//createuser
//deleteuser
//calculatestatistics
//getquiz
//answerquiz or /postquiz