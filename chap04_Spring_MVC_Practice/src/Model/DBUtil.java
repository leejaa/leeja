package Model;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Service;

@Service
public class DBUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection open() throws Exception {
		String url = "jdbc:oracle:thin:@192.168.10.1:1521:xe";
		String user = "leeja"; // ������
		String password = "oracle"; // ������й�ȣ
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
}
