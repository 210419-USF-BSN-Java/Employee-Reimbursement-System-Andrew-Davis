package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Type;

public interface TypeDao {
	public Type getById(Integer i);
	public ArrayList<Type> getAll();
	public Integer add(Type s);
	public Integer update(Type s);
	public Integer delete(Type s);
}
