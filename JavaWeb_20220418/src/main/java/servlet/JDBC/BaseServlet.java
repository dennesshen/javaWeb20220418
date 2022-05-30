package servlet.JDBC;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {
	protected Connection conn;
	
	@Override
	public void init() throws ServletException {
		 conn = (Connection)getServletContext().getAttribute("conn");
	}

}
