package searchmusic;

import musician.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import musician.MusicianDTO;
import DBUtil.DBUtil;

public class searchmusician {
	
	public MusicianDTO findMusicianDTO(String find)
	   {
	      String sql="select * from musician where musicianID like ?";
	      Connection con=null;
	      PreparedStatement ptmt = null;
	      ResultSet rs=null;
	      MusicianDTO user=null;
	      try
	      {
	         con=DBUtil.getConnect();
	         ptmt=con.prepareStatement(sql);
	         ptmt.setString(1,"%"+find+"%");
	         rs=ptmt.executeQuery();
	         while(rs.next())
	         {
	            user=new MusicianDTO(rs.getString(1),rs.getString(2),rs.getString(3)
	                  ,rs.getString(4));
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
	      
	      return user;

	   }
	
	
	public ArrayList<MusicianDTO> findMusicianDTO1(String find1)
	   {
	      String sql="select * from musician where UPPER(musicianName) like ?";
	      Connection con=null;
	      PreparedStatement ptmt = null;
	      ResultSet rs=null;
	      MusicianDTO user=null;
	      String find = find1.toUpperCase();
	      ArrayList<MusicianDTO> list=new ArrayList<MusicianDTO>();
	      
	      try
	      {
	         con=DBUtil.getConnect();
	         ptmt=con.prepareStatement(sql);
	         ptmt.setString(1,"%"+find+"%");
	         rs=ptmt.executeQuery();
	         while(rs.next())
	         {
	            user=new MusicianDTO(rs.getString(1),rs.getString(2),rs.getString(3)
	                  ,rs.getString(4));
	            list.add(user);
	         }
	         System.out.println(list);
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
	
	

