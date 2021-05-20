package com.revature.models;

import java.io.Serializable;



public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer reimb_status_id; // primary key
	private String reimb_status;
	
	
	
	// constructors
	public Status() {
		
	}
	public Status(String reimb_status) {
		super();
		this.reimb_status = reimb_status;
	}
	public Status(Integer reimb_status_id, String reimb_status) {
		super();
		this.reimb_status_id = reimb_status_id;
		this.reimb_status = reimb_status;
	}
	public Integer getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(Integer reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public String getReimb_status() {
		return reimb_status;
	}
	public void setReimb_status(String reimb_status) {
		this.reimb_status = reimb_status;
	}
	@Override
	public String toString() {
		return "Status [reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reimb_status == null) ? 0 : reimb_status.hashCode());
		result = prime * result + ((reimb_status_id == null) ? 0 : reimb_status_id.hashCode());
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
		Status other = (Status) obj;
		if (reimb_status == null) {
			if (other.reimb_status != null)
				return false;
		} else if (!reimb_status.equals(other.reimb_status))
			return false;
		if (reimb_status_id == null) {
			if (other.reimb_status_id != null)
				return false;
		} else if (!reimb_status_id.equals(other.reimb_status_id))
			return false;
		return true;
	}
}
