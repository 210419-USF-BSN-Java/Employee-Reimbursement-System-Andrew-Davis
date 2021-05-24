package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class LoginDelegate implements Delegatable {
	
	private UserPostgres up = new UserPostgres();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		// After processing the path attribute set at the Servlet Context/Application level here ...
		String path = (String) request.getAttribute("path");
		
		
		
		// ... you will construct a switch statement to handle the different HTTP methods
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
                    // logic
					break;
				case "PUT":
					// logic
					break;
				case "POST":
					// logic

					String username = request.getParameter("username");
                    String password = request.getParameter("password");

                    User user = up.getByUsernameAndPassword(username, password);

					// Employees have even user_ids
					// Managers have odd user_ids
                    if(user.getUser_role_id() == 1) {
                        String token = user.getErs_user_id() + ":" + "Employee";
						response.setStatus(200);
						response.setHeader("Authorization", token);
                    }
					else if(user.getUser_role_id() == 2) {
                        String token = user.getErs_user_id() + ":" + "Manager";
						response.setStatus(200);
						response.setHeader("Authorization", token);
                    } 
					else {
						response.sendError(401);
					}
                    
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

				Integer userRoleId = 0;
				if(userRoleStr == "1") {
					userRoleId = 1;
				} else {
					userRoleId = 2;
				}

				// check to see if there is a valid user and if that user is the appropriate
				// role in their token
				User u = up.getById(Integer.parseInt(idStr));
				if (u != null && u.getUser_role_id().equals(userRoleId)) {
					return true;
				}
			}
		}
		return false;
	}
}
