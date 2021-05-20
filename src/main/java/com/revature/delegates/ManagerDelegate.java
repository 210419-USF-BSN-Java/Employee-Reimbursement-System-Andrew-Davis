package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.ManagerServiceImplementation;

public class ManagerDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();
	
	private ManagerServiceImplementation ms = new ManagerServiceImplementation();
	
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
					
					/*
					User u = mp.getById(1);
					PrintWriter pm = response.getWriter();
					pm.write(om.writeValueAsString(u));
					*/
					
					///* serve page
					request.getRequestDispatcher("static/views/manager.html").forward(request, response);
					//*/
					
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
