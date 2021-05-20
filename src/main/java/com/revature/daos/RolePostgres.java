package com.revature.daos;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.utils.DBConnection;

public class RolePostgres implements RoleDao {

	@Override
	public Role getById(Integer r_id) {
		String sql = "SELECT * FROM ers_user_roles WHERE ers_user_role_id = ?";
		
		Role r = new Role();
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				r.setErs_user_role_id(rs.getInt("ers_user_role_id"));
				r.setUser_role(rs.getString("user_role"));
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public ArrayList<Role> getAll() {
		String sql = "SELECT * FROM ers_user_roles";
		
		ArrayList<Role> ra = new ArrayList<>();
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				Role r = new Role();
				r.setErs_user_role_id(rs.getInt("role_id"));
				r.setUser_role(rs.getString("user_role"));
				ra.add(r);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return ra;
	}

	@Override
	public Integer add(Role r) {
		String sql = "INSERT INTO ers_user_roles (user_role) VALUES (?)";
		
		Integer affectedRows = 0;
		
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getUser_role());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer update(Role r) {
		String sql = "UPDATE ers_user_roles SET user_role = ? WHERE ers_user_role_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, r.getUser_role());
			ps.setInt(2, r.getErs_user_role_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}

	@Override
	public Integer delete(Role r) {
		String sql = "DELETE FROM ers_user_roles WHERE ers_user_role_id = ?";
		
		Integer affectedRows = 0;
		try(Connection conn = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getErs_user_role_id());
			
			affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return affectedRows;
	}
}
