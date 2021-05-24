package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	public Reimbursement getById(Integer i);
	public ArrayList<Reimbursement> getAll();
	public Integer add(Integer id, Reimbursement r);
	public Integer update(Reimbursement r);
	public Integer updateId(Reimbursement r);
	public Integer delete(Reimbursement r);
}
