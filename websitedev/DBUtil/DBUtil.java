package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
		
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}

	}
	
	public static Connection getConnect(){
		Connection con = null;
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user= "scott";
		String password= "tiger";
		
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection con){
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
