package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/getHeader")
public class HeaderServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> header = req.getHeaderNames();
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		while(header.hasMoreElements()) {
			String headerName = header.nextElement();
			String headerContent = req.getHeader(headerName);
			writer.write(headerName + " : " + headerContent + "<br/>");
			System.out.println(headerName + " : " + headerContent + "<br/>");
		}

		
	}
}
