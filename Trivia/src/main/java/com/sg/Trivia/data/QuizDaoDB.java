package com.sg.Trivia.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.sg.Trivia.Models.Quiz;

public class QuizDaoDB implements QuizDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public Quiz getQuizByGameId(int id) {
		try {
			final String SELECT_QUIZ_BY_GAMEID = "SELECT * FROM quiz WHERE GameId = ?";
			return jdbc.queryForObject(SELECT_QUIZ_BY_GAMEID, new QuizMapper(), id);
		} catch (DataAccessException ex) {
			return null;
		}

	}

	public Quiz getQuizByUserId(int id) {
		try {
			final String SELECT_QUIZ_BY_USERID = "SELECT * FROM quiz WHERE UserId = ?";
			return jdbc.queryForObject(SELECT_QUIZ_BY_USERID, new QuizMapper(), id);
		} catch (DataAccessException ex) {
			return null;
		}

	}

	@Override
	public List<Quiz> getAllQuizzes() {
		final String SELECT_ALL_QUIZZES = "SELECT * FROM quiz";
		return jdbc.query(SELECT_ALL_QUIZZES, new QuizMapper());
	}

	@Override
	@Transactional
	public Quiz addQuiz(Quiz quiz) {
		final String INSERT_QUIZ = "INSERT INTO quiz(GameId, UserId, TotalQuestion, NumberCorrect) "
				+ "VALUES(?,?,?,?)";
		jdbc.update(INSERT_QUIZ, quiz.getGameID(), quiz.getUserID(), quiz.getTotalQuestion(), quiz.getNumberCorrect());
		int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
		quiz.setGameID(newId);
		return quiz;
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		final String UPDATE_QUIZ = "UPDATE quiz SET TotalQuestion = ?, NumberCorrect = ? " + "WHERE GameId = ?";
		jdbc.update(UPDATE_QUIZ, quiz.getTotalQuestion(), quiz.getNumberCorrect(), quiz.getGameID());

	}

	@Override
	@Transactional
	public void deleteQuizbById(int id) {
		final String DELETE_QUIZ = "DELETE FROM quiz WHERE GameId = ?";
		jdbc.update(DELETE_QUIZ, id);

	}

	public static final class QuizMapper implements RowMapper<Quiz> {
		@Override
		public Quiz mapRow(ResultSet rs, int index) throws SQLException {
			Quiz quiz = new Quiz();
			quiz.setGameID(rs.getInt("id"));
			quiz.setUserID(rs.getInt("UserId"));
			quiz.setTotalQuestion(rs.getInt("TotalQuestion"));
			quiz.setNumberCorrect(rs.getInt("NumberCorrect"));

			return quiz;
		}
	}

}