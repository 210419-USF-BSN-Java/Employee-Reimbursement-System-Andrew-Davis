package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.EmployeePostgres;
import com.revature.daos.ManagerPostgres;
import com.revature.models.User;

public class LoginDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();
	
	private EmployeePostgres ep = new EmployeePostgres();
	private ManagerPostgres mp = new ManagerPostgres();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// After processing the path attribute set at the Servlet Context/Application level here ...
		String path = (String) request.getAttribute("path");
		
		
		
		// ... you will construct a switch statement to handle the different HTTP methods
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    User emp = null;
                    User man = null;
                    
                    // assuming the user exists in one of the two tables and the user input is correct ...
                    // ... one of these will be null and the other not.
                    // Return the one that is not
                    emp = ep.getByUsernameAndPassword(username, password);
                    man = mp.getByUsernameAndPassword(username, password);

                    if(emp != null) {
						String token = emp.getErs_user_id() + ":" + "Employee";
						response.setStatus(200);
						response.setHeader("Authorization", token);
                    }
                    else if(man != null) {
                        String token = man.getErs_user_id() + ":" + "Manager";
						response.setStatus(200);
						response.setHeader("Authorization", token);
                    } else {
						response.sendError(401);
					}
                    
                    // once the user is returned, the client side javascript will set the session variable ...
                    // ... for the user id
                    
					break;
				case "PUT":
					// logic
					break;
				case "POST":
					// logic
					break;
				case "DELETE":
					// logic
					break;
				default:
					// logic
			}
		} else {
			// further processing
		}
	}
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		// check to see if there is an auth header
		if (authToken != null) {
			String[] tokenArr = authToken.split(":");
			// if the token is formatted the way we expect, we can take the id from it and
			// query for that user
			if (tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String userRoleStr = tokenArr[1];

				// for employee
				User u_e = ep.getById(Integer.parseInt(idStr));
				if (u_e != null && u_e.getUser_role_id().equals(userRoleStr)) {
					return true;
				}
				// for manager
				User u_m = mp.getById(Integer.parseInt(idStr));
				if (u_m != null && u_m.getUser_role_id().equals(userRoleStr)) {
					return true;
				}
			}
		}
		return false;
	}
}
