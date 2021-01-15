package com.sg.Trivia.data;

import java.util.List;

import com.sg.Trivia.Models.Quiz;
import com.sg.Trivia.Models.User;

public interface QuizDao {

	List<Quiz> getAllQuiz();

	Quiz addQuiz(Quiz quiz);

	Quiz getQuizbyId(int id);

}
