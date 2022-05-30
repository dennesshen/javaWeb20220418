package servlet.JDBC;

import java.io.IOException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/jdbc/create/createTable")
public class CreateUserTable extends BaseServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String createTableSQL ="create table if not exists user("
				+ "id integer primary key,"
				+ "name text not null,"
				+ "age integer,"
				+ "createtime datetime default current_timestamp"
				+ ")";
		
		try (Statement statement = conn.createStatement()){
			boolean result = statement.execute(createTableSQL);
			if (result) {
				resp.getWriter().write("insert Table ok");
			}else {
				resp.getWriter().write("create Table ok");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
}
