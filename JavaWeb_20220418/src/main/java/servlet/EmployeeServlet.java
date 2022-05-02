package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmployeeService;
@WebServlet("/servlet/employee")
public class EmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//verified 驗證
		
		
		req.getParameterMap().entrySet().forEach(e ->System.out.println(e.getKey() +" : " + Arrays.toString(e.getValue())));
		resp.setContentType("text/html; charset=UTF-8");
		
		
		
		resp.getWriter().write("姓名:"+ req.getParameter("employeeName") +"<p/>");
		resp.getWriter().write("年齡:" + req.getParameter("employeeAge") +"<p/>");
		resp.getWriter().write("性別:" + req.getParameter("employeeSex") +"<p/>");
		resp.getWriter().write("階級:" + req.getParameter("employeePosition") +"<p/>");
		resp.getWriter().write("生日:" + req.getParameter("employeeBirth") +"<p/>");
		resp.getWriter().write("語言:" + Arrays.toString(req.getParameterValues("employeeLanguage")) +"<p/>");
		resp.getWriter().write("備註:" + req.getParameter("employeeMemo") +"<p/>");
		resp.getWriter().write("<hr/>");

		
		PrintWriter writer = resp.getWriter();
		req.getParameterMap().entrySet().forEach(e -> writer.write(e.getKey() + " : " + Arrays.toString(e.getValue()) +"<p/>"));
		EmployeeService.getEmployeeService().transDataToObject(req.getParameterMap())
											.findAll()
											.forEach(System.out::println);
	}
}
