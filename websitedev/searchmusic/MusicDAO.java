package searchmusic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import musician.MusicianDTO;
import DBUtil.DBUtil;



public class MusicDAO {

	
	  public MusicDAO() 
	  {
		super();
	  }



		public ArrayList<MusicDTO> findMusic1(String find1)
		   {
		      String sql="select * from music where UPPER(musicname) like ?";
		      //select * from music where musicname like %a%;
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      String find = find1.toUpperCase();
		      ArrayList<MusicDTO> list=new ArrayList<MusicDTO>();
		      MusicDTO user=null;
		      try
		      {
		         con=DBUtil.getConnect();
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,"%"+find+"%");
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		            user=new MusicDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
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
		         DBUtil.close(null, ptmt, con);   
		      }
		      
		      return list;
		   }
		
		public ArrayList<MusicDTO> findMusic3(String find)
		   {
		      String sql="select * from music where upper(musicianID) like ?";
		      //select * from music where musicname like %a%;
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      ArrayList<MusicDTO> list=new ArrayList<MusicDTO>();
		      MusicDTO user=null;
		      try
		      {
		         con=DBUtil.getConnect();
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,"%"+find+"%");
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		            user=new MusicDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
		            list.add(user);
		         }
		         rs.close();
		         System.out.println(list);
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(null, ptmt, con);   
		      }
		      
		      return list;
		   }



		public ArrayList<MusicDTO> allfindMusic1(String word) {
			String sql="select * from music where musicname like ? ";
			Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      ArrayList<MusicDTO> list=new ArrayList<MusicDTO>();
		      MusicDTO user=null;
		      try
		      {
		         con=DBUtil.getConnect();
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,"%"+word+"%");
		         rs=ptmt.executeQuery();
		         
		         while(rs.next())
		         {
		            user=new MusicDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
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
		         DBUtil.close(null, ptmt, con);   
		      }
		      
		      return list;
		}
		
	///////////////////////////
		public ArrayList<MusicDTO> findMusiciango(String word) {
			String sql="select * from music where musicianid = ?";
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      MusicDTO user=null;
		      ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
		      try
		      {
		         con=DBUtil.getConnect();
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,word);
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		            user=new MusicDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8));
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
		         DBUtil.close(null, ptmt, con);   
		      }
		      
		      return list;
		}
	
	

}
