package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Status;

public interface StatusDao {
	public Status getById(Integer i);
	public ArrayList<Status> getAll();
	public Integer add(Status s);
	public Integer update(Status s);
	public Integer delete(Status s);
}
