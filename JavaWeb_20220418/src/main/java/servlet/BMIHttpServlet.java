package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIHttpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().write("call by Get <p/>");
		Double height = Double.parseDouble(req.getParameter("height"));
		Double weight = Double.parseDouble(req.getParameter("weight"));
		Double bmi = weight / Math.pow(height/100,2);
		resp.getWriter().write("Height = " + height + "<p/>" );
		resp.getWriter().write("Weight = " + weight + "<p/>");
		resp.getWriter().write(String.format("Bmi = %.2f", bmi));
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("call by Post");
	}
	
}
