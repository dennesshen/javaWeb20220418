package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/servlet/*")
public class WatermarkFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		MyResponse myResponse = new MyResponse(res);
		chain.doFilter(req, myResponse);
		
		String responseHTML = myResponse.getHTMLSource();
		responseHTML = responseHTML.replaceAll("<body", "<body bgcolor='red'");
		res.getWriter().print(responseHTML);
		
		
	}
}
