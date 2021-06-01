package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.revature.daos.ReimbursementPostgres;
import com.revature.daos.RolePostgres;
import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserServiceImplementation;

public class ReimbDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();

	private ReimbursementPostgres rp = new ReimbursementPostgres();
	private UserServiceImplementation usi = new UserServiceImplementation();
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
					// logic to create and new reimbursement request
					Integer user_id = Integer.parseInt(request.getParameter("id"));
					Double amount = Double.parseDouble(request.getParameter("amount"));
					Timestamp submitted = new Timestamp(System.currentTimeMillis());
					Timestamp resolved = null;
					String description = request.getParameter("description");
					String receipt = request.getParameter("receipt");
					Integer author = user_id;
					// status = 1: Pending
					
					// This will have to take in a string, and with a switch/if, set an int and pass in to the constructor
					Integer type = Integer.parseInt(request.getParameter("type"));
					
					
					
					// 1 : Pending
					Reimbursement r = new Reimbursement(amount, submitted, resolved, description, receipt, author, null, 1, type);
					
					usi.submitReimbursementRequest(user_id, r);
					
					response.setStatus(201);
					response.sendRedirect("/ers/employee");
					
					break;
				case "DELETE":
					// logic
					break;
				default:
			}
		} else {
			// further processing
			// further processing
//            int userId = Integer.valueOf(path);

            switch (request.getMethod()) {
                case "GET":
                case "PUT":
                    // logic to update a user
                    break;
				case "POST":
					// logic to update a user
				break;
                case "DELETE":
                    //logic to remove a user
                    break;
                default:
                    response.sendError(400, "Method not supported.");
            }
		}	
	}
}