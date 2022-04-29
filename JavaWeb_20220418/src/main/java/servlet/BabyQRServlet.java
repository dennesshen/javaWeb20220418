package servlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/baby/qr/image")
public class BabyQRServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		File file = new File("C:\\Users\\student\\baby.png");
		OutputStream outputStream = resp.getOutputStream();
		Files.copy(file.toPath(), outputStream);
		
		outputStream.close();
		
	}
}
