package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private Connection conn;
	
	public DBConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "developerJ", "jyj9706");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
/*
 *  ● 객체 지향 프로그래밍: Class를 이용한 프로그래밍 방법. 
 *  								DBConnect 객체를 미리 만들어 놓지 않았다면, DAO에서 SQL을 작성할 때마다 Connection 객체를 이용해서 DB 연동을 해야 한다.
 *  
 *   ● DBConnect 객체: 접근지정자를 private로 한 Connection 객체를 저장할 필드를 만든다.  
 *   								생성자에서 DB 연결을 한다. => 객체 생성 시, DB 연결을 하도록 만들어 둔다.
 *   								DB 연결이 된 Connection 객체를 메소드를 통해서 외부로 보낸다.
 */
 