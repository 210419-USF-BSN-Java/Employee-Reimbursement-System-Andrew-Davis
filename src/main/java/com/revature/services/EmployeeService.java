package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface EmployeeService {
	public void login(); // determine return types and parameters for all
	public void logout();
	public void submitReimbursementRequest(Integer i, Reimbursement r);
	public void uploadReceipt();
	public ArrayList<Reimbursement> viewPendingRequests();
	public ArrayList<Reimbursement> viewResolvedRequests();
	public User viewInformation();
	public void updateInformation();
}
