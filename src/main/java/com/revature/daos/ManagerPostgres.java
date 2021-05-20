package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.utils.DBConnection;

public class ManagerPostgres implements ManagerDao {
	
	@Override
	public User getById(Integer u_id) {
		
		String sql = "SELECT * FROM ers_users WHERE ers_user_id = ? AND user_role_id = 2";

		User u = new User();
		try(Connection conn = DBConnection.getConnectionFromFile()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				u.setErs_user_id(rs.getInt("ers_user_id"));
	        	u.setErs_username(rs.getString("ers_username"));
	        	u.setErs_password(rs.getString("ers_password"));
	        	u.setUser_first_name(rs.getString("user_first_name"));
	        	u.setUser_last_name(rs.getString("user_last_name"));
	        	u.setUser_email(rs.getString("user_email"));
	        	u.setUser_role_id(rs.getInt("user_role_id"));
	        }
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	@Override
	public ArrayList<User> getAll() {
		String sql = "SELECT * FROM ers_users WHERE user_role_id = 2";
		
		ArrayList<User> ua = new ArrayList<>();
		try(Connection conn = DBConnection.getConnectionFromFile()){
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				User u = new User();
				u.setErs_user_id(rs.getInt("ers_user_id"));
	        	u.setErs_username(rs.getString("ers_username"));
	        	u.setErs_password(rs.getString("ers_password"));
	        	u.setUser_first_name(rs.getString("user_first_name"));
	        	u.setUser_last_name(rs.getString("user_last_name"));
	        	u.setUser_email(rs.getString("user_email"));
	        	u.setUser_role_id(rs.getInt("user_role_id"));
	            ua.add(u);
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Integer add(User u) {
		// INSERT ONE
		String sql = "INSERT INTO ers_users"
				+ " (ers_username,"
				+ " ers_password,"
				+ " user_first_name,"
				+ " user_last_name"
				+ " user_email"
				+ " user_role_id) VALUES (?, ?, ?, ?, ?, 2)";
		
		Integer affectedRows = 0;
		
		try(Connection connection = DBConnection.getConnectionFromFile()) {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, u.getErs_username());
			ps.setString(2, u.getErs_password());
			ps.setString(3, u.getUser_first_name());
	        ps.setString(4, u.getUser_last_name());
	        ps.setString(5, u.getUser_email());
	        
	        affectedRows = ps.executeUpdate();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
        }
        return affectedRows;
	}
	
	@Override
	public Integer update(User u) {
		// UPDATE ONE 
		String str = "UPDATE ers_users"
				+ " SET ers_username = ?,"
				+ " ers_password = ?,"
				+ " user_first_name = ?,"
				+ " user_last_name = ?"
				+ " user_email = ?"
				+ " user_role_id = ?"
				+ " WHERE ers_user_id = ?";
		
		int affectedRows = 0;
		
        try(Connection connection =  DBConnection.getConnectionFromFile()) {
        	PreparedStatement ps = connection.prepareStatement(str);
        	ps.setString(1, u.getErs_username());
			ps.setString(2, u.getErs_password());
			ps.setString(3, u.getUser_first_name());
	        ps.setString(4, u.getUser_last_name());
	        ps.setString(5, u.getUser_email());
	        ps.setInt(6, u.getUser_role_id());
	        ps.setInt(7, u.getErs_user_id());
            
            affectedRows = ps.executeUpdate();
        } catch (IOException | SQLException e) {
        	e.printStackTrace();
        }
        return affectedRows;
	}
	
	@Override
	public Integer delete(User u) {
		// DELETE ONE
        String sql = "DELETE FROM ers_users WHERE ers_user_id = ? AND user_role_id = 2";
        
        Integer affectedRows = 0;
        
        try(Connection connection =  DBConnection.getConnectionFromFile()) {
        	PreparedStatement ps0 = connection.prepareStatement(sql);
        	ps0.setInt(1, u.getErs_user_id());
	        affectedRows = ps0.executeUpdate();
        } catch (IOException | SQLException e) {
        	e.printStackTrace();
        }
        return affectedRows;
	}
}
