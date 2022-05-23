package servlet.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/cart/buy")
public class BuyServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		HttpSession httpSession = req.getSession();
		List<String> products = null;
		synchronized (httpSession) {
			if (httpSession.getAttribute("products") == null) {
				products = new ArrayList<String>();
			}else {
				products = (List<String>) httpSession.getAttribute("products");
			}
			
			String product = req.getParameter("product");
			products.add(product);
			httpSession.setAttribute("products", products);
		}
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet/cart/view");
		requestDispatcher.forward(req, resp);
	}
}
