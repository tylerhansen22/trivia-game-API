package com.sg.Trivia.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sg.Trivia.Models.User;

@Repository
public class UserDaoDB implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public User getUserById(int id) {
		try {
			final String GET_USER_BY_ID = "SELECT * FROM user WHERE id = ?";
			return jdbc.queryForObject(GET_USER_BY_ID, new UserMapper(), id);
		} catch (DataAccessException ex) {
			return null;
		}

	}

	@Override
	@Transactional
	public User addUser(User user) {
		final String INSERT_USER = "INSERT INTO user(id,FirstName,LastName, UserName,Password,Email) "
				+ "VALUES(?,?,?,?,?,?)";
		jdbc.update(INSERT_USER, user.getId(), user.getFirstName(), user.getLastName(), user.getUserName(),
				user.getPassword(), user.getEmail());

		int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
		user.setId(newId);
		return user;
	}

	
	
	//May have to add email 
	@Override
	public void updateUser(User user) {
		final String UPDATE_USER = "UPDATE user SET FirstName = ?, LastName = ?, UserName = ?, Password = ?, "
				+ "WHERE id =?";
		jdbc.update(UPDATE_USER, user.getFirstName(), user.getLastName(), user.getUserName(), user.getPassword());
	}

	@Override
	public void deleteUserById(int id) {
		final String DELETE_QUIZ = "DELETE FROM quiz WHERE UserId = ?";
		jdbc.update(DELETE_QUIZ, id);

		final String DELETE_USER = "DELETE FROM user WHERE UserId = ?";
		jdbc.update(DELETE_USER, id);

	}

	@Override
	public List<User> getAllUsers() {
		final String GET_ALL_USER = "SELECT * FROM User";
		return jdbc.query(GET_ALL_USER, new UserMapper());
	}

	public static final class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setPassword(rs.getString("Password"));
			user.setUserName(rs.getString("UserName"));
			user.setEmail(rs.getString("Email"));

			return user;
		}

	}
}
