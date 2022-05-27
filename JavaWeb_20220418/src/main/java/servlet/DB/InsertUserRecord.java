package servlet.DB;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/jdbc/getOneValue/")
public class InsertUserRecord extends BaseServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectSQL = "Select id, name, age, createtime from user where id=?";
		
		try (PreparedStatement statement = conn.prepareStatement(selectSQL)){
			statement.setInt(1, new Random().nextInt(46) );
			ResultSet resultSet = statement.executeQuery();
			User user = new User();
			user.setId(resultSet.getInt("id"));
			user.setName(resultSet.getString("name"));
			user.setAge(resultSet.getInt("age"));
			user.setCreatetime(resultSet.getDate("createtime"));
			resp.getWriter().write(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
}
