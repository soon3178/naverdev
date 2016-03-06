package Myalbum;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class MymusicDAO {

	
	  public MymusicDAO() 
	  {
		super();
	  }



	  
	  
		public ArrayList<MymusicDTO> findMymusic(String find)
		   {
		      String sql="select * from mymusic where myalbumid = ?";
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      ArrayList<MymusicDTO> list=new ArrayList<MymusicDTO>();
		      MymusicDTO user=null;
		      try
		      {
		         con=DButil.getConnection();
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,find);
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		        	 System.out.println("øÕ¿œπÆ");
		            user=new MymusicDTO(rs.getString(1),rs.getString(2));
		            list.add(user);
		         }
		         rs.close();
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DButil.close(null, ptmt, con);   
		      }
		      
		      return list;
		   }
	
		
	
	

}
