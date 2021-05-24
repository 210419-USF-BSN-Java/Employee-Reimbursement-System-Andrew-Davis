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

public class ReimbDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();

	private ReimbursementPostgres rp = new ReimbursementPostgres();
	
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
					
					rp.add(user_id, r);
					
//					request.getRequestDispatcher("/Projec1/employee").forward(request, response);
					
					
					// Instead of adding a reimbursement which has a ton of fields i just called add on role because it is simpler...
					// .. for this test
					// String role = request.getParameter("user_role");
					// Role r = new Role(role);
					// rop.add(r);
					
//					response.setStatus(201);
					
					response.sendRedirect("/Project1/employee");
					
					break;
				case "DELETE":
					// logic
					break;
				default:
			}
		} else {
			// further processing
			// further processing
            int userId = Integer.valueOf(path);

            switch (request.getMethod()) {
                case "GET":
                case "PUT":
                    // logic to update a user
                    break;
				case "POST":
					// logic to update a user
					String timestampAsString = "Nov 12, 2018 13:02:56.12345678";
					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(request.getParameter("submitted"));
					LocalDateTime localDateTime1 = LocalDateTime.from(formatter1.parse(timestampAsString));
					Timestamp timestamp1 = Timestamp.valueOf(localDateTime1);
					
					DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(request.getParameter("resolved"));
					LocalDateTime localDateTime2 = LocalDateTime.from(formatter2.parse(timestampAsString));
					Timestamp timestamp2 = Timestamp.valueOf(localDateTime2);
					
					Integer id = Integer.parseInt(request.getParameter("id"));
					Double amount = Double.parseDouble(request.getParameter("amount"));
					Timestamp submitted = timestamp1;
					Timestamp resolved = timestamp2;
					String description = request.getParameter("description");
//					String receipt = request.getParameter("receipt");
					Integer author = Integer.parseInt(request.getParameter("author"));
					Integer resolver = Integer.parseInt(request.getParameter("resolver"));
					Integer status = Integer.parseInt(request.getParameter("status"));
					Integer type = Integer.parseInt(request.getParameter("type"));
					
					// you can just pass in a 1 here into the constructor to indicate that it is an employee ...
					// ... as the manager does not have an update info section
					Reimbursement r = new Reimbursement(id, amount, submitted, resolved, description, null, author, resolver, status, type);
					
					rp.updateId(r);
					
//					request.getRequestDispatcher("/static/view/employee.html").forward(request, response);
					response.sendRedirect("/Project1/employee");
                    
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