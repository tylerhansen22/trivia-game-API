package com.sg.Trivia.Models;

public class Quiz {
	private int GameID;
	private int Score;
	private int NumberCorrect;
	private int TotalQuestion;

	public int getGameID() {
		return GameID;
	}

	public void setGameID(int gameID) {
		GameID = gameID;
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

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

}
