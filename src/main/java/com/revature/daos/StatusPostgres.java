package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;

import com.revature.models.Status;
import com.revature.utils.DBConnection;

public class StatusPostgres implements StatusDao {

	@Override
	public Status getById(Integer s_id) {
		String sql = "SELECT * ers_reimbursement_statuses WHERE reimb_status_id = ?";
		
		Status s = new Status();
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				s.setReimb_status_id(rs.getInt("reimb_status_id"));
				s.setReimb_status(rs.getString("reimb_status"));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public ArrayList<Status> getAll() {
		String sql = "SELECT * ers_reimbursement_statuses";
		
		ArrayList<Status> sa = new ArrayList<>();
 		try(Connection conn = DBConnection.getConnectionFromFile()){
 			Statement s = conn.createStatement();
 			ResultSet rs = s.executeQuery(sql);
 			while(rs.next()) { 
 				Status st = new Status();
 				st.setReimb_status_id(rs.getInt("reimb_status_id"));
				st.setReimb_status(rs.getString("reimb_status"));
 				sa.add(st);
 			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return sa;
	}

	@Override
	public Integer add(Status s) {
		String sql = "INSERT INTO ers_reimbursement_statuses (reimb_status) VALUES (?)";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getReimb_status());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer update(Status s) {
		String sql = "UPDATE ers_reimbursement_statuses SET reimb_status = ? WHERE reimb_status_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getReimb_status());
			ps.setInt(2, s.getReimb_status_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer delete(Status s) {
		String sql = "DELETE FROM ers_reimbursement_statuses WHERE reimb_status_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getReimb_status_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}
