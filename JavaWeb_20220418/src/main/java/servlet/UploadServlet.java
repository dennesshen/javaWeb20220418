package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import service.InputStreamPrintService;

@WebServlet("/servlet/upload")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*2, //2MB
		maxFileSize = 1024*1024*10, //10MB
		maxRequestSize = 1024*1024*50 //50MB
)
public class UploadServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		//new InputStreamPrintService().print(req.getInputStream());
		PrintWriter printWriter = resp.getWriter();
		req.getParts().stream()
				      .filter(part -> part.getName().equals("cname"))
					  .forEach(part -> {
						try {
							String cname = IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8.name());
							printWriter.write(part.getName() + ":" + cname); 
						} catch (Exception e) {
							e.printStackTrace();
						}
					  });
		
		
	}
}
