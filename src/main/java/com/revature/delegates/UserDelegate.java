package com.revature.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserPostgres;
import com.revature.models.User;

public class UserDelegate implements Delegatable {
    private ObjectMapper om = new ObjectMapper();

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
                    u = up.getById(userId);
                    if (u != null) {
                        response.getWriter().write(om.writeValueAsString(u));
                    } else {
                        response.sendError(404, "User not found.");
                    }
                case "PUT":
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
