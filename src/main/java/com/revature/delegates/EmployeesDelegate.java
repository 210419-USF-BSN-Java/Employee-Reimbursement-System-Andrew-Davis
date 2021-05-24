package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class EmployeesDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();
	
	private UserPostgres up = new UserPostgres();

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String path = (String) request.getAttribute("path");
		
		// ... you will construct a switch statement to handle the different HTTP methods
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
					ArrayList<User> ua = up.getAll();
					
					PrintWriter pm = response.getWriter();
					pm.write(om.writeValueAsString(ua));
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
}
