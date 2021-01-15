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
import com.sg.Trivia.Models.User;

@Repository
public class UserDaoDB implements UserDao {

	private final JdbcTemplate jdbc;

	@Autowired
	public UserDaoDB(JdbcTemplate jdbcTemplate) {
		this.jdbc = jdbcTemplate;
	}

	@Override
	public List<User> getAllUsers() {
		final String sql = "SELECT username FROM Username;";
		return jdbc.query(sql, new UserMapper());
	}

	@Override
	public User findById(String id) {

		final String sql = "SELECT username " + "FROM Username WHERE username = ?;";

		return jdbc.queryForObject(sql, new UserMapper(), id);
	}

	private static final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User td = new User();
			td.setId(rs.getString("username"));

			return td;
		}
	}

}
