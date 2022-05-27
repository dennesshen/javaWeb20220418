package servlet.DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/jdbc/create")
public class CreateDBServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String db_path = "C:\\Users\\student\\git\\javaWeb20220418\\JavaWeb_20220418\\db";
		
		String db_name = "webdb.db";
		
		String db_url = "jdbc:sqlite:" + db_path +"/" +db_name;
		
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(db_url);
			resp.getWriter().write("establish ok");
		} catch (Exception e) {
			resp.getWriter().write(e.toString());
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
