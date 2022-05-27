package servlet.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Tomcat 開啟中.....");
		String db_path = "C:\\Users\\student\\git\\javaWeb20220418\\JavaWeb_20220418\\db";
		
		String db_name = "webdb.db";
		
		String db_url = "jdbc:sqlite:" + db_path +"/" +db_name;
		
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(db_url);
			System.out.println("資料庫成功連結");
		} catch (Exception e) {
			e.printStackTrace();
		}
		sce.getServletContext().setAttribute("conn", connection);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Tomcat 關閉中.....");

		Object connection = sce.getServletContext().getAttribute("conn");
		if(connection instanceof Connection) {
				try {
					((Connection)connection).close();
					System.out.println("資料庫連結關閉");

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
}
