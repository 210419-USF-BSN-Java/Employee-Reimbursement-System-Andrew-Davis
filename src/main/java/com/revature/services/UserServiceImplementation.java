package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.UserPostgres;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class UserServiceImplementation implements UserService {

	private UserPostgres up = new UserPostgres();
	private ReimbursementPostgres rp = new ReimbursementPostgres();

	// Employee //
	@Override
	public Integer submitReimbursementRequest(Integer id, Reimbursement r) {
		// TODO Auto-generated method stub
		// ADD
		Integer affectedRows = rp.add(id, r);
		
		return affectedRows;
	}
	@Override
	public void uploadReceipt() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User viewInformation(Integer id) {
		// TODO Auto-generated method stub
		
		User u = up.getById(id);
		
		return u;
	}
	@Override
	public Integer updateInformation(User u) {
		// TODO Auto-generated method stub
		
		// GET
		User user = up.getById(u.getErs_user_id());
		// UPDATE
		Integer affectedRows = up.update(user);
		
		return affectedRows;
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
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		
		User user = up.getByUsernameAndPassword(username, password);
		
		return user;
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
