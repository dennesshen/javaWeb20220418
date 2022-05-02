package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/todayHeader")
public class TodayHeaderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		String headerContent = req.getHeader("sec-ch-ua");
		if( headerContent.contains("Google Chrome") ) {
			writer.write("您使用的瀏覽器是"+ headerContent.split(",")[2].split(";")[0].replace("\"", " ") + "<br/>");
			writer.write("現在的時刻:"+ new Date());
		}else {
			writer.write("您使用的瀏覽器是"+ headerContent.split(",")[2].split(";")[0].replace("\"", " ") + "<br/>");
			writer.write("請改用Chrome瀏覽器");
		}
	}
}
