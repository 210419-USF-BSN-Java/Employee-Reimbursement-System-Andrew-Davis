package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer ers_user_id;
	private String ers_username;
	private String ers_password;
	private String user_first_name;
	private String user_last_name;
	private String user_email;
	private Integer user_role_id;
		
	
	
	public User() {
		
	}
	public User(String ers_username, String ers_password, String user_first_name, String user_last_name,
			String user_email, Integer user_role_id) {
		super();
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}
	public User(Integer ers_user_id, String ers_username, String ers_password, String user_first_name,
			String user_last_name, String user_email, Integer user_role_id) {
		super();
		this.ers_user_id = ers_user_id;
		this.ers_username = ers_username;
		this.ers_password = ers_password;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_email = user_email;
		this.user_role_id = user_role_id;
	}
	public Integer getErs_user_id() {
		return ers_user_id;
	}
	public void setErs_user_id(Integer ers_user_id) {
		this.ers_user_id = ers_user_id;
	}
	public String getErs_username() {
		return ers_username;
	}
	public void setErs_username(String ers_username) {
		this.ers_username = ers_username;
	}
	public String getErs_password() {
		return ers_password;
	}
	public void setErs_password(String ers_password) {
		this.ers_password = ers_password;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Integer getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(Integer user_role_id) {
		this.user_role_id = user_role_id;
	}
	@Override
	public String toString() {
		return "User [ers_user_id=" + ers_user_id + ", ers_username=" + ers_username + ", ers_password=" + ers_password
				+ ", user_first_name=" + user_first_name + ", user_last_name=" + user_last_name + ", user_email="
				+ user_email + ", user_role_id=" + user_role_id + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ers_password == null) ? 0 : ers_password.hashCode());
		result = prime * result + ((ers_user_id == null) ? 0 : ers_user_id.hashCode());
		result = prime * result + ((ers_username == null) ? 0 : ers_username.hashCode());
		result = prime * result + ((user_email == null) ? 0 : user_email.hashCode());
		result = prime * result + ((user_first_name == null) ? 0 : user_first_name.hashCode());
		result = prime * result + ((user_last_name == null) ? 0 : user_last_name.hashCode());
		result = prime * result + ((user_role_id == null) ? 0 : user_role_id.hashCode());
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
		User other = (User) obj;
		if (ers_password == null) {
			if (other.ers_password != null)
				return false;
		} else if (!ers_password.equals(other.ers_password))
			return false;
		if (ers_user_id == null) {
			if (other.ers_user_id != null)
				return false;
		} else if (!ers_user_id.equals(other.ers_user_id))
			return false;
		if (ers_username == null) {
			if (other.ers_username != null)
				return false;
		} else if (!ers_username.equals(other.ers_username))
			return false;
		if (user_email == null) {
			if (other.user_email != null)
				return false;
		} else if (!user_email.equals(other.user_email))
			return false;
		if (user_first_name == null) {
			if (other.user_first_name != null)
				return false;
		} else if (!user_first_name.equals(other.user_first_name))
			return false;
		if (user_last_name == null) {
			if (other.user_last_name != null)
				return false;
		} else if (!user_last_name.equals(other.user_last_name))
			return false;
		if (user_role_id == null) {
			if (other.user_role_id != null)
				return false;
		} else if (!user_role_id.equals(other.user_role_id))
			return false;
		return true;
	}
}
