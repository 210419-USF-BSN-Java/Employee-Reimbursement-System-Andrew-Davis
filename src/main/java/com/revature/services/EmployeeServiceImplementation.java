package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserPostgres;
import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.RolePostgres;
import com.revature.daos.StatusPostgres;
import com.revature.daos.TypePostgres;
import com.revature.models.Reimbursement;
import com.revature.models.User;


public class EmployeeServiceImplementation implements EmployeeService {
	
	private UserPostgres up = new UserPostgres();
	private ReimbursementPostgres rep = new ReimbursementPostgres();
	@Override
	public void login() {
		// TODO Auto-generated method stub
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
	}

	@Override
	public void submitReimbursementRequest(Integer i, Reimbursement r) {
		// TODO Auto-generated method stub
	}

	@Override
	public void uploadReceipt() {
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

	@Override
	public User viewInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateInformation() {
		// TODO Auto-generated method stub
	}
}
