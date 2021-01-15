package com.sg.Trivia.data;

import java.util.List;

import com.sg.Trivia.Models.User;

public interface UserDao {


	List<User> getAllUsers();

	User findById(String id);

}
