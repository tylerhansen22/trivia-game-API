package com.sg.Trivia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sg.Trivia.Models.Quiz;
import com.sg.Trivia.Models.User;
import com.sg.Trivia.data.QuizDao;
import com.sg.Trivia.data.UserDao;

@Controller
public class MainController {

	@Autowired
	QuizDao quizDao;
	UserDao userDao;

	@PostMapping("createuser")
	public String createUser(String firstName, String lastName, String UserName, String Password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(UserName);
		user.setPassword(Password);
		return "redirect:/users";// Maybe
	}

	@PostMapping("deleteuser")
	public void deleteUser(int userid) {
		// [insert code to create user] Unneeded
	}

	@GetMapping("getquiz")
	public String getquiz(int id, Model model) {
		Quiz quiz = quizDao.getQuizByGameId(id);
		model.addAttribute("quiz", quiz);
		return "Quiz Details";

	}

	@PostMapping("getaveragescore")
	public double getaveragescore() {
		return 0;
		// average of all quizs for that user
	}

	@PostMapping("postquiz") // grabing quiz from front
	public void postquiz(int userid) {
		// [insert code to create user]
	}

	@GetMapping("getUser")
	public String getUsers(int id, Model model) {
		User user = userDao.getUserById(id);
		model.addAttribute("User", user);
		return "User Details";

	}

	@GetMapping("Users")
	public String displayUsers(Model model) {
		List<User> users = userDao.getAllUsers();
		model.addAttribute("students", users);
		return "users";
	}

}
//createuser
//deleteuser
//calculatestatistics
//getquiz
//answerquiz or /postquiz