package com.sg.Trivia.data;

import java.util.List;

import com.sg.Trivia.Models.Quiz;

public interface QuizDao {
	Quiz getQuizByGameId(int id);

	Quiz getQuizByUserId(int id);

	List<Quiz> getAllQuizzes();

	Quiz addQuiz(Quiz quiz);

	void updateQuiz(Quiz quiz);

	void deleteQuizbById(int id);
}
