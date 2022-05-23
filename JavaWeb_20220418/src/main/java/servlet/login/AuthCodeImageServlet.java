package servlet.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servlet/auth")
public class AuthCodeImageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String authCode = String.format("%04d", new Random().nextInt(10000));
		httpSession.setAttribute("authCode", authCode);
		
		ImageIO.write(drawAuthCodePicture(authCode), "JPEG", resp.getOutputStream());
		
	}
	
	private BufferedImage drawAuthCodePicture(String authCode) {
		BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		
		Graphics graphics = img.getGraphics();
		graphics.setColor(Color.yellow);
		graphics.fillRect(0, 0, 80, 30);
		
		graphics.setColor(Color.BLACK);
		//設定字型(字體, 字樣, 尺寸)
		graphics.setFont(new Font("新細明體", Font.PLAIN , 30));
		graphics.drawString(authCode, 10, 23);
		
		graphics.setColor(Color.RED);
		Random random = new Random();
		for (int i = 0; i <10; i++) {
			int x1 = random.nextInt(80);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(80);
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}
		
		return img ;
	}
	
}
