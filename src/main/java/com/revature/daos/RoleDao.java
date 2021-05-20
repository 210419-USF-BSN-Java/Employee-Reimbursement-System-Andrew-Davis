package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Role;

public interface RoleDao {
	public Role getById(Integer i);
	public ArrayList<Role> getAll();
	public Integer add(Role r);
	public Integer update(Role r);
	public Integer delete(Role r);
}
