package com.sg.Trivia.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.sg.Trivia.Models.Quiz;

@Repository
public class QuizDaoDB implements QuizDao {

	private final JdbcTemplate jdbc;

	@Autowired
	public QuizDaoDB(JdbcTemplate jdbcTemplate) {
		this.jdbc = jdbcTemplate;
	}

	@Override
	public List<Quiz> getAllQuiz() {
		final String sql = "SELECT * FROM Quiz;";
		return jdbc.query(sql, new QuizMapper());
	}

	@Override
	public Quiz getQuizbyId(int id) {
		final String sql = "SELECT QuizId,NumberCorrect,TotalQuestions,Score " + "FROM Quiz WHERE QuizId = ?;";
		return jdbc.queryForObject(sql, new QuizMapper(), id);
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		final String sql = "INSERT INTO Quiz(NumberCorrect, TotalQuestions) VALUES(?,?);";
		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

		jdbc.update((Connection conn) -> {

			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, quiz.getNumberCorrect());
			statement.setInt(2, quiz.getTotalQuestion());
			return statement;

		}, keyHolder);

		quiz.setGameID(keyHolder.getKey().intValue());
		//quiz.setScore((quiz.getNumberCorrect() / quiz.getTotalQuestion()) * 100);

		return quiz;

	}

	private static final class QuizMapper implements RowMapper<Quiz> {

		@Override
		public Quiz mapRow(ResultSet rs, int index) throws SQLException {
			Quiz td = new Quiz();
			td.setGameID(rs.getInt("QuizId"));
			td.setNumberCorrect(rs.getInt("NumberCorrect"));
			td.setTotalQuestion(rs.getInt("TotalQuestions"));
			td.setScore(rs.getInt("Score"));
			return td;
		}
	}

}
