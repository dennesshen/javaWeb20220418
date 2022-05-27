package servlet.DB;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.javafaker.Faker;

@WebServlet("/servlet/jdbc/insert/")
public class getUserRecord extends BaseServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String insertSQL = "insert into user(name, age) values(?, ?)";
		
		try (PreparedStatement statement = conn.prepareStatement(insertSQL)){
			statement.setString(1, new Faker().name().fullName());
			statement.setInt(2, new Random().nextInt(30) + 10);
			int affectRowCount = statement.executeUpdate();
			resp.getWriter().write(affectRowCount+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
}
