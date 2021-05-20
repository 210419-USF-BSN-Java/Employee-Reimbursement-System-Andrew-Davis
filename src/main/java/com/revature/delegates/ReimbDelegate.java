package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.RolePostgres;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;

public class ReimbDelegate implements Delegatable {

	private ReimbursementPostgres rp = new ReimbursementPostgres();
	private RolePostgres rop = new RolePostgres();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		// After processing the path attribute set at the Servlet Context/Application level here ...
		String path = (String) request.getAttribute("path");
		
		
		
		// ... you will construct a switch statement to handle the different HTTP methods
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
					// logic
					request.getRequestDispatcher("/static/views/add_reimb.html").forward(request, response);
					break;
				case "PUT":
					// logic
					
					
					break;
				case "POST":
					// logic
//					Integer user_id = Integer.parseInt(request.getParameter("user"));
//					
//					Double amount = Double.parseDouble(request.getParameter("amount"));
//					Timestamp submitted = Timestamp.valueOf(request.getParameter("submitted"));
//					Timestamp resolved = Timestamp.valueOf(request.getParameter("resolved"));
//					String description = request.getParameter("description");
//					String receipt = request.getParameter("receipt");
//					Integer author = user_id;
//					// null
//					// null
//					
//					// This will have to take in a string, and with a switch/if, set an int and pass in to the constructor
//					Integer type_id = Integer.parseInt(request.getParameter("type"));
//					
//					Reimbursement r = new Reimbursement(amount, submitted, resolved, description, receipt, author, null, null, type_id);
//					
//					rp.add(user_id, r);
//					
//					request.getRequestDispatcher("/").forward(request, response);
					
					
					String role = request.getParameter("user_role");
					Role r = new Role(role);
					rop.add(r);
					
//					response.setStatus(201);
					
					response.sendRedirect("/Project1/");
					
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
