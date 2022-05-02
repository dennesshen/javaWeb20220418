package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LottoService;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HttpServlet {
	
	private LottoService lottoService;
	
	@Override
	public void init() throws ServletException {
		lottoService = new LottoService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int count = Integer.parseInt(req.getParameter("count"));
		List<Integer> lottos = lottoService.getLottos(count);
		
		//設定
		req.setAttribute("lottos", lottos);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/lottos_result.jsp");
		requestDispatcher.forward(req, resp);
	}
}
