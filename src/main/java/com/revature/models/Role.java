package com.revature.models;

import java.io.Serializable;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Integer ers_user_role_id; // primary
	public String user_role;
	
	
	
	// constructors
	public Role() {
		
	}
	public Role(String user_role) {
		super();
		this.user_role = user_role;
	}
	public Role(Integer ers_user_role_id, String user_role) {
		super();
		this.ers_user_role_id = ers_user_role_id;
		this.user_role = user_role;
	}
	public Integer getErs_user_role_id() {
		return ers_user_role_id;
	}
	public void setErs_user_role_id(Integer ers_user_role_id) {
		this.ers_user_role_id = ers_user_role_id;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	@Override
	public String toString() {
		return "Role [ers_user_role_id=" + ers_user_role_id + ", user_role=" + user_role + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_user_role_id == null) ? 0 : ers_user_role_id.hashCode());
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (ers_user_role_id == null) {
			if (other.ers_user_role_id != null)
				return false;
		} else if (!ers_user_role_id.equals(other.ers_user_role_id))
			return false;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		return true;
	}
}
