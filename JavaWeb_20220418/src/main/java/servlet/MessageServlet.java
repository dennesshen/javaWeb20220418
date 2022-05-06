package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MessageService;

@WebServlet("/servlet/message")
public class MessageServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String content = req.getParameter("content");
		MessageService messageService = new MessageService();
		int httpCode = messageService.pushMessage(content);
		
		resp.setContentType("text/html; charset=UTF-8");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/message_result.jsp");
		req.setAttribute("content", content);
		req.setAttribute("httpCode", httpCode);
		requestDispatcher.forward(req, resp);

	}
}
