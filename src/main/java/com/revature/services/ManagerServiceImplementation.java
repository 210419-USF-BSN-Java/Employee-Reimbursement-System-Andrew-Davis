package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserPostgres;
import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.RolePostgres;
import com.revature.daos.StatusPostgres;
import com.revature.daos.TypePostgres;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ManagerServiceImplementation implements ManagerService {
	
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
	public void settleRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Reimbursement> viewPendingRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewReceipts() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Reimbursement> viewResolvedRequests() {
		// TODO Auto-generated method stub
		return null;
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
}
