package Myalbum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
   //1. ����̹��ε�-DBUtil Ŭ������ �ε��ɶ� �޸𸮿� �Ҵ�
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
   //3. �ڿ��ݳ�
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
   //2.connection �����ϱ�
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