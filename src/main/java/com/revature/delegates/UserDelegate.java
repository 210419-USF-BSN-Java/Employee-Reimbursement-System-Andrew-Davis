package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserPostgres;
import com.revature.models.User;
import com.revature.services.UserServiceImplementation;

public class UserDelegate implements Delegatable {
    private ObjectMapper om = new ObjectMapper();

    private UserPostgres up = new UserPostgres();
	private UserServiceImplementation usi = new UserServiceImplementation();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO Auto-generated method stub

        // After processing the path attribute set at the Servlet Context/Application level here ...
		String path = (String) request.getAttribute("path");
		
		

		// ... you will construct a switch statement to handle the different HTTP methods
		if (path == null || path.equals("")) {
			switch(request.getMethod()) {
				case "GET":
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
            int userId = Integer.valueOf(path);
            User u = null;

            switch (request.getMethod()) {
                case "GET":
                	// logic to get a user
                    u = usi.viewInformation(userId);
                    if (u != null) {
                        response.getWriter().write(om.writeValueAsString(u));
                    } else {
                        response.sendError(404, "User not found.");
                    }
                case "PUT":
                    // logic to update a user
                    break;
				case "POST":
					// logic to update a user
					String username = request.getParameter("username");
					String password = request.getParameter("password");
					String firstname = request.getParameter("firstname");
					String lastname = request.getParameter("lastname");
					String email = request.getParameter("email");
					Integer role = Integer.parseInt(request.getParameter("role"));
					
					// you can just pass in a 1 here into the constructor to indicate that it is an employee ...
					// ... as the manager does not have an update info section
					User new_u = new User(userId, username, password, firstname, lastname, email, role);
					
					up.update(new_u);
					
					
					response.sendRedirect("/ers/employee");
                    
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
