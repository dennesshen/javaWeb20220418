package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet/area"})
public class AreaServlet extends HttpServlet{
	
	protected void calculate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		Double radios = Double.parseDouble(req.getParameter("radio"));
		Double area = Math.pow(radios, 2) * Math.PI;
		Double volume = 4/3 * Math.pow(radios,3) * Math.PI;
		resp.getWriter().write("半徑 : " + radios + "<p/>" );
		resp.getWriter().write(String.format("圓面積 : %.2f <p/>", area));
		resp.getWriter().write(String.format("球體積: %.2f <p/>", volume));
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		calculate(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		calculate(req, resp);
	}
}
