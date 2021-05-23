package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.RolePostgres;
import com.revature.models.Reimbursement;
import com.revature.models.Role;

public class ReimbDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();

	private ReimbursementPostgres rp = new ReimbursementPostgres();
	// private RolePostgres rop = new RolePostgres();
	
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
					
					// use the dao/service to get all of the reimbursements in the form of a List<Reimbursement>
					ArrayList<Reimbursement> allReimb = rp.getAll();

					// convery that list into json
					// send that json to the javascript
					PrintWriter pm = response.getWriter();
					pm.write(om.writeValueAsString(allReimb));
					
					break;
				case "PUT":
					// logic
					
					
					break;
				case "POST":
					// logic
//					Integer user_id = Integer.parseInt(request.getParameter("user"));
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
					
					
					// Instead of adding a reimbursement which has a ton of fields i just called add on role because it is simpler...
					// .. for this test
					// String role = request.getParameter("user_role");
					// Role r = new Role(role);
					// rop.add(r);
					
//					response.setStatus(201);
					
					// response.sendRedirect("/Project1/employee");
					
					break;
				case "DELETE":
					// logic
					break;
				default:
			}
		} else {
			// further processing
		}	
	}
}
