package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.EmployeeDelegate;
import com.revature.delegates.LoginDelegate;
import com.revature.delegates.ManagerDelegate;
import com.revature.delegates.ReimbDelegate;

public class RequestHelper {
	
	EmployeeDelegate ed = new EmployeeDelegate();
	ManagerDelegate md = new ManagerDelegate();
	ReimbDelegate rd = new ReimbDelegate();
	LoginDelegate ld = new LoginDelegate();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// /Project1/reimbursement
		StringBuilder uriString = new StringBuilder(request.getRequestURI());
		
		// /reimbursement
		uriString.replace(0, request.getContextPath().length() + 1, "");
		
		if(uriString.indexOf("/") != -1) {
			// IMPORTANT
			// Setting this path as an attribute makes it available to the rest of the application ...
			// ... because it is saved in SERVLET CONTEXT SCOPE / APPLICATION SCOPE ...
			// ... and not in the other SERVLET CONFIG SCOPE / SERVLET SCOPE
			request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1));
			
			uriString.replace(uriString.indexOf("/"), uriString.length(), "");
			// at this point, uriString = planets
		}
		
		

		switch (uriString.toString()) {

			case "login":
				ld.process(request, response);
				break;

			case "employee":
				// if(!ld.isAuthorized(request)) {
				// 	response.sendError(401);
				// 	return;
				// }
				ed.process(request, response);
				break;

			case "manager":
				// if(!ld.isAuthorized(request)) {
				// 	response.sendError(401);
				// 	return;
				// }
				md.process(request, response);
				break;

			case "reimbursement":
				// if(!ld.isAuthorized(request)) {
				// 	response.sendError(401);
				// 	return;
				// }
				rd.process(request, response);
				break;

			default:
				response.sendError(404, "Path not supported");
		}
	}
}
