package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ManagerService {
	public void login(); // determine return types and parameters for all
	public void logout();
	public void settleRequest();
	public ArrayList<Reimbursement> viewPendingRequests();
	public void viewReceipts();
	public ArrayList<Reimbursement> viewResolvedRequests();
	public ArrayList<User> viewAllEmployees();
	public ArrayList<Reimbursement> viewEmployeeRequests();
}
