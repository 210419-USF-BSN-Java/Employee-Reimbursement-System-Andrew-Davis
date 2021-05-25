package com.revature.services;

import java.util.ArrayList;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class UserServiceImplementation implements UserService {

	// Employee //
	@Override
	public void submitReimbursementRequest(Integer i, Reimbursement r) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void uploadReceipt() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User viewInformation() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updateInformation() {
		// TODO Auto-generated method stub
		
	}

	
	
	// Manager //
	@Override
	public void settleRequest() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void viewReceipts() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<User> viewAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Reimbursement> viewEmployeeRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	// Employee and Manager //
	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Reimbursement> viewPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Reimbursement> viewResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
	}
}
