package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//WebServlet 配置訊息
@WebServlet("/servlet/lucky/number")
public class LuckyNumberServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Integer luckyNumber = new Random().nextInt(100) + 1 ;
		
		//Server端編碼方式:
		res.setCharacterEncoding("UTF-8");
		//Server端回應給瀏覽器的文件格式及編碼
		res.setContentType("text/html; charset=UTF-8");
		
		res.getWriter().write("<HTML>");
//		res.getWriter().write("<head>");
//		res.getWriter().write("<meta charset=\"UTF-8\">");
//		res.getWriter().write("</head>");
		res.getWriter().write("<body>");
		res.getWriter().write("幸運數字 : "+ luckyNumber);
		res.getWriter().write("</body>");
		res.getWriter().write("</HTML>");
		

	}

}
