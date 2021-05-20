package com.revature.models;

import java.io.Serializable;

public class Type implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer reimb_type_id; // primary
	private String reimb_type;
	
	
	
	// constructors
	public Type() {
		
	}
	public Type(String reimb_type) {
		super();
		this.reimb_type = reimb_type;
	}
	public Type(Integer reimb_type_id, String reimb_type) {
		super();
		this.reimb_type_id = reimb_type_id;
		this.reimb_type = reimb_type;
	}
	public Integer getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(Integer reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	public String getReimb_type() {
		return reimb_type;
	}
	public void setReimb_type(String reimb_type) {
		this.reimb_type = reimb_type;
	}
	@Override
	public String toString() {
		return "Type [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
		result = prime * result + ((reimb_type_id == null) ? 0 : reimb_type_id.hashCode());
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
		Type other = (Type) obj;
		if (reimb_type == null) {
			if (other.reimb_type != null)
				return false;
		} else if (!reimb_type.equals(other.reimb_type))
			return false;
		if (reimb_type_id == null) {
			if (other.reimb_type_id != null)
				return false;
		} else if (!reimb_type_id.equals(other.reimb_type_id))
			return false;
		return true;
	}
}
