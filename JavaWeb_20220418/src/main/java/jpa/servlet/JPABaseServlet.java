package jpa.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import jpa.service.JPAService;


public class JPABaseServlet extends HttpServlet{
	
	protected JPAService jpaService;
	
	@Override
	public void init() throws ServletException {
		jpaService = new JPAService();
	}
}
