package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {

	// Employee //
	public Integer submitReimbursementRequest(Integer id, Reimbursement r);
	public void uploadReceipt();
	
	public User viewInformation(Integer id);
	public Integer updateInformation(User u);
	
	// Manager //
	public void settleRequest();
	public void viewReceipts();
	public ArrayList<User> viewAllEmployees();
	public ArrayList<Reimbursement> viewEmployeeRequests();
	
	// Employee and Manager //
	public User login(String username, String password);
	public void logout();
	public ArrayList<Reimbursement> viewPendingRequests();
	public ArrayList<Reimbursement> viewResolvedRequests();
}
