package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//WebServlet 配置訊息
@WebServlet("/servlet/TimeStampServlet")
public class TimeStampServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Date today = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss E");
		String todayString = simpleDateFormat.format(today);
		System.out.println(todayString);

		//Server端編碼方式:
		res.setCharacterEncoding("UTF-8");
		//Server端回應給瀏覽器的文件格式及編碼
		res.setContentType("text/html; charset=UTF-8");
		
		res.getWriter().write("<HTML>");
//		res.getWriter().write("<head>");
//		res.getWriter().write("<meta charset=\"UTF-8\">");
//		res.getWriter().write("</head>");
		res.getWriter().write("<body>");
		res.getWriter().write(todayString);
		res.getWriter().write("</body>");
		res.getWriter().write("</HTML>");
		

	}

}
