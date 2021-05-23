package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.User;

public interface UserDao {
	public User getById(Integer i);
	public User getByUsernameAndPassword(String username, String password);
	public ArrayList<User> getAll();
	public Integer add(User u);
	public Integer update(User u);
	public Integer delete(User u);
}
