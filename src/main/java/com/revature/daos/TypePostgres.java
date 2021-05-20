package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.models.Type;
import com.revature.utils.DBConnection;

public class TypePostgres implements TypeDao {

	@Override
	public Type getById(Integer t_id) {
		String sql = "SELECT * FROM ers_reimbursement_types WHERE reimb_type_id = ?";
		
		Type t = new Type();
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t.setReimb_type_id(t_id);
				t.setReimb_type(rs.getString("type_type"));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	@Override
	public ArrayList<Type> getAll() {
		String sql = "SELECT * FROM ers_reimbursement_types";
		
		ArrayList<Type> ra = new ArrayList<>();
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Type r = new Type();
				r.setReimb_type_id(rs.getInt("reimb_type_id"));
				r.setReimb_type(rs.getString("reimb_type"));
				ra.add(r);
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ra;
	}

	@Override
	public Integer add(Type t) {
		String sql = "INSERT INTO ers_reimbursement_types (reimb_type) VALUES (?)";
		
		Integer affectedRows = 0;
		
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getReimb_type());
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer update(Type t) {
		String sql = "UPDATE ers_reimbursement_types SET reimb_type = ? WHERE reimb_type_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getReimb_type());
			ps.setInt(2, t.getReimb_type_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer delete(Type r) {
		String sql = "DELETE FROM ers_reimbursement_types WHERE reimb_type_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getReimb_type_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}
