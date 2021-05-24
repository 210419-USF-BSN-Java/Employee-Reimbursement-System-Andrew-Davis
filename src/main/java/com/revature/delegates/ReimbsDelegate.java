package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ReimbursementPostgres;
import com.revature.models.Reimbursement;

public class ReimbsDelegate implements Delegatable {
	private ObjectMapper om = new ObjectMapper();

	private ReimbursementPostgres rp = new ReimbursementPostgres();

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
//					Integer id = Integer.parseInt(request.getParameter("id"));
//					Integer choice = Integer.parseInt(request.getParameter("choice"));
//					Integer resolver = Integer.parseInt(request.getParameter("resolver"));
					
					Reimbursement r = rp.getById(1);
					
//					if(choice == 2) {
//						r.setReimb_status_id(2);
//						r.setReimb_resolver(3);
//					}
//					else if(choice == 2) {
//						r.setReimb_status_id(3);
//						r.setReimb_resolver(3);
//					}
					r.setReimb_status_id(2);
					r.setReimb_resolver(3);
					
					rp.update(r);
					
					response.sendRedirect("/Project1/manager");
					
					break;
				case "DELETE":
					// logic
					break;
				default:
			}
		} else {
			// further processing|
            // int id = Integer.valueOf(path);

            switch (request.getMethod()) {
                case "GET":
                	//logic
                case "PUT":
                    //logic
                    break;
				case "POST":
					//logic
                case "DELETE":
                    //logic
                    break;
                default:
                    response.sendError(400, "Method not supported.");
            }
		}	
	}
}
