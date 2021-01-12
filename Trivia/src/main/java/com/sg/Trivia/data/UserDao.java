package com.sg.Trivia.data;

import java.util.List;

import com.sg.Trivia.Models.User;

public interface UserDao {
	User getUserById(int id);

	User addUser(User user);

	void updateUser(User user);

	void deleteUserById(int id);

	List<User> getAllUsers();

}
