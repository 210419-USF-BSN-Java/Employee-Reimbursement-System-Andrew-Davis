package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.DBConnection;

public class ReimbursementPostgres implements ReimbursementDao {

	@Override
	public Reimbursement getById(Integer r_id) {
		String sql = "SELECT * FROM ers_reimbursements WHERE reimb_id = ?";
		
		Reimbursement r = new Reimbursement();
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getDouble("reimb_amount"));
				r.setReimb_submitted(rs.getTimestamp("reimb_submitted"));
				r.setReimb_resolved(rs.getTimestamp("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				r.setReimb_receipt(rs.getString("reimb_receipt"));
				r.setReimb_author(rs.getInt("reimb_author"));
				r.setReimb_resolver(rs.getInt("reimb_resolver"));
				r.setReimb_status_id(rs.getInt("reimb_status_id"));
				r.setReimb_type_id(rs.getInt("reimb_type_id"));
			}
		} catch(IOException | SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Reimbursement> getAll() {
		String sql = "SELECT * FROM ers_reimbursements";
		
		ArrayList<Reimbursement> ra = new ArrayList<>();
		try(Connection conn = DBConnection.getConnectionFromFile()){
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setReimb_id(rs.getInt("reimb_id"));
				r.setReimb_amount(rs.getDouble("reimb_amount"));
				r.setReimb_submitted(rs.getTimestamp("reimb_submitted"));
				r.setReimb_resolved(rs.getTimestamp("reimb_resolved"));
				r.setReimb_description(rs.getString("reimb_description"));
				r.setReimb_receipt(rs.getString("reimb_receipt"));
				r.setReimb_author(rs.getInt("reimb_author"));
				r.setReimb_resolver(rs.getInt("reimb_resolver"));
				r.setReimb_status_id(rs.getInt("reimb_status_id"));
				r.setReimb_type_id(rs.getInt("reimb_type_id"));
				ra.add(r);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ra;
	}

	@Override
	public Integer add(Integer id, Reimbursement r) {
		String sql = "INSERT INTO ers_reimbursements ("
				+ " reimb_amount,"
				+ " reimb_submitted,"
				+ " reimb_resolved,"
				+ " reimb_description,"
				+ " reimb_receipt"
				+ " reimb_author) VALUES (?, ?, ?, ?, ?, ?)";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, r.getReimb_amount());
			ps.setTimestamp(2, r.getReimb_submitted());
			ps.setTimestamp(3, r.getReimb_resolved());
			ps.setString(4, r.getReimb_description());
			ps.setString(5, r.getReimb_receipt());
			ps.setInt(6, id);
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer update(Reimbursement r) {
		String sql = "UPDATE ers_reimbursements"
				+ "SET reimb_amount = ?, "
				+ " reimb_submitted = ?,"
				+ " reimb_resolved = ?,"
				+ " reimb_description = ?,"
				+ " reimb_receipt = ?,"
				+ " reimb_author = ?,"
				+ " reimb_resolver = ?,"
				+ " reimb_status_id = ?,"
				+ " reimb_type_id = ?"
				+ " WHERE reimb_id = ?";
		
		Integer affectedRows = 0;
		
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, r.getReimb_amount());
			ps.setTimestamp(2, r.getReimb_submitted());
			ps.setTimestamp(3, r.getReimb_resolved());
			ps.setString(4, r.getReimb_description());
			ps.setString(5, r.getReimb_receipt());
			ps.setInt(6, r.getReimb_author());
			ps.setInt(7, r.getReimb_resolver());
			ps.setInt(8, r.getReimb_status_id());
			ps.setInt(9, r.getReimb_type_id());
			ps.setInt(10, r.getReimb_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer delete(Reimbursement r) {
		String sql = "DELETE FROM ers_reimbursements WHERE reimb_id = ?";
		
		Integer affectedRows = 0;
		
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getReimb_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}
