package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {

	// Employee //
	public void submitReimbursementRequest(Integer i, Reimbursement r);
	public void uploadReceipt();
	
	public User viewInformation();
	public void updateInformation();
	
	// Manager //
	public void settleRequest();
	public void viewReceipts();
	public ArrayList<User> viewAllEmployees();
	public ArrayList<Reimbursement> viewEmployeeRequests();
	
	// Employee and Manager //
	public void login();
	public void logout();
	public ArrayList<Reimbursement> viewPendingRequests();
	public ArrayList<Reimbursement> viewResolvedRequests();
}
