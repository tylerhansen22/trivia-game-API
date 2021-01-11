package com.sg.Trivia.Models;

public class Quiz {
	private int GameID;
	private int UserID;
	private int NumberCorrect;
	private int TotalQuestion;

	public int getGameID() {
		return GameID;
	}

	public void setGameID(int gameID) {
		GameID = gameID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getNumberCorrect() {
		return NumberCorrect;
	}

	public void setNumberCorrect(int numberCorrect) {
		NumberCorrect = numberCorrect;
	}

	public int getTotalQuestion() {
		return TotalQuestion;
	}

	public void setTotalQuestion(int totalQuestion) {
		TotalQuestion = totalQuestion;
	}

	public double calculateStatistics(int numberCorrect, int totalQuestions) {
		return (numberCorrect / totalQuestions);
	}

}
