package Myalbum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
   //1. 드라이버로딩-DBUtil 클래스가 로딩될때 메모리에 할당
   static
   {
      try
      {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      }
   }
   //3. 자원반납
   public static void close(ResultSet rs, Statement stmt, Connection con)
   {
      try
      {
         if(rs!=null) rs.close();
         if(stmt!=null)stmt.close();
         if(con!=null)con.close();
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
   }
   {
      
   }
   //2.connection 설정하기
   public static Connection getConnection()
   {
      Connection con=null;
         
      String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
      String username="scott";
      String password="tiger";
      try
      {
         con=DriverManager.getConnection(url, username, password);
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      return con;
   }
}