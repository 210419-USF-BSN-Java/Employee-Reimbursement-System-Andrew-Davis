package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.User;

public interface ManagerDao {
	public User getById(Integer i);
	public ArrayList<User> getAll();
	public Integer add(User u);
	public Integer update(User u);
	public Integer delete(User u);
}
