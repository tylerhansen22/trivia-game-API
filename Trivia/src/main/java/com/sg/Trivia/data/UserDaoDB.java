package com.sg.Trivia.data;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sg.Trivia.Models.User;

@Repository
public class UserDaoDB {

	@Autowired
	JdbcTemplate jdbc;

	public User getUserById(int id) {

	}

	public User addUser(User user) {

	}

	public void updateUser(user user) {

	}

	public void deleteUserById(int id) {

	}

	public List<User> getAllUsers() {

	}


		public static final class UserMapper{
			 public User mapRow(ResultSet rs, int index) throws SQLException {
		            User user = new User();
		            user.setId(rs.getInt("id"));
		            user.setFirstName(rs.getString("firstName"));
		            user.setLastName(rs.getString("lastName"));
		            user.setPassword(rs.getString("Password"));
		            user.setUserName(rs.getString("UserName"));
		            
		            return user;
		        }

}
