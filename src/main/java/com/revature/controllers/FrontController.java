package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlets.DefaultServlet;

public class FrontController extends DefaultServlet {
	private static final long serialVersionUID = 1L;
	
	RequestHelper rh = new RequestHelper();
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// /Project1/reimbursement
		String path = request.getRequestURI().substring(request.getContextPath().length());
		
		// /reimbursement
		if(path.startsWith("/static/") || path.equals("/") || path.equals("/index.html") ) {
			super.doGet(request, response);
		} else {
			rh.processRequest(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}
}
