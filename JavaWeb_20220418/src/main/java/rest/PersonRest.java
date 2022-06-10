package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest/*")
public class PersonRest extends HttpServlet{
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp)  throws  ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println(req.getMethod());
		writer.println(req.getPathInfo());
//		writer.println(req.getParameterMap());
//		writer.println(req.getParameterMap().size());
		ServletInputStream inputStream = req.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String args = bufferedReader.readLine();
		if (args == null) {
			req.getParameterMap().entrySet().stream()
								 .forEach(m -> writer.println(m.getKey()+"="+m.getValue()[0]));
			System.out.println("test1");
			return;
		}
		for (String data : args.split("&")) {
			System.out.println("test2");
			System.out.println(data);

			String[] row = data.split("=");
			writer.println(row[0]+"="+row[1]);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
}
