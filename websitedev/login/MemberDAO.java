package login;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBUtil.*;


public class MemberDAO {

	
	  public MemberDAO() 
	  {
		super();
	  }



		public int insert(MemberDTO dto)
		   {
		      String sql="insert into member values(?,?,?,?,?)";
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      int result=0;
		      try
		      {
		         con=DBUtil.getConnect();
		         
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,dto.getMemberid());
		         ptmt.setString(2,dto.getPass());
		         ptmt.setString(3,dto.getNickname());
		         ptmt.setInt(4,10000);
		         ptmt.setString(5,dto.getEmail());
		       
		         
		         result=ptmt.executeUpdate();
		      
		      }
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(null, ptmt, con);   
		      }   
		      return result;
		   }
		
	
		
		
		public boolean nickcheck(String nickname)
		   {
			String sql="select * from member where nickname=? ";
		      
		   	
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      boolean check = false;
		      try
		      {
		    	  con=DBUtil.getConnect();
			      ptmt=con.prepareStatement(sql);
			      ptmt.setString(1,nickname);
			      rs=ptmt.executeQuery();
			      if(rs.next())
			      {
			    	  check = true;
			      }
			      rs.close();
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(rs, ptmt, con);   
		      }
		      return check;
		   }
		
		public MemberDTO login(String id,String pass)
        {
           String sql="select * from member where memberid=? and pass=?";
           
           
           MemberDTO user=null;
          Connection con=null;
           PreparedStatement ptmt = null;
           ResultSet rs=null;
           try
           {
              con=DBUtil.getConnect();
              ptmt=con.prepareStatement(sql);
              ptmt.setString(1,id);
              ptmt.setString(2,pass);
              rs=ptmt.executeQuery();
              if(rs.next())
              {
            	  user=new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		    			  ,rs.getInt(4),rs.getString(5));  
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
		
		public int pointmodify(String id,int point)
        {
			 String sql="update member set point = ? where memberid = ?";
		   MemberDTO user=null;
          Connection con=null;
           PreparedStatement ptmt = null;
           int result=0;
           try
           {
              con=DBUtil.getConnect();
              ptmt=con.prepareStatement(sql);
              ptmt.setInt(1,point);
              ptmt.setString(2,id);
              result=ptmt.executeUpdate();
           }
        
           catch(SQLException e)
           {
              e.printStackTrace();
           }
           finally
           {
              DBUtil.close(null, ptmt, con);   
           }
           return result;
        }
		
		public MemberDTO idcheck1(String id)
		   {
			
			String sql="select * from member where memberid=? ";
			 MemberDTO user=null;
			Connection con=null;
		    PreparedStatement ptmt = null;
		    ResultSet rs=null;
		    try
		      {
		    	  con=DBUtil.getConnect();
			      ptmt=con.prepareStatement(sql);
			      ptmt.setString(1,id);
			      rs=ptmt.executeQuery();
			      if(rs.next())
			      {
			    	  user=new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3)
			    			  ,rs.getInt(4),rs.getString(5));  
			      }
			      rs.close();
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(rs, ptmt, con);   
		      }
		      return user;
		   }
		
		
		public boolean idcheck(String id)
		   {
			
			String sql="select * from member where memberid=? ";
		    
			Connection con=null;
		    PreparedStatement ptmt = null;
		    ResultSet rs=null;
		    boolean check = false;
		    try
		      {
		    	  con=DBUtil.getConnect();
			      ptmt=con.prepareStatement(sql);
			      ptmt.setString(1,id);
			      rs=ptmt.executeQuery();
			      if(rs.next())
			      {
			    	  check = true;
			      }
			      rs.close();
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(rs, ptmt, con);   
		      }
		      return check;
		   }		
		
		public boolean emailcheck(String email)
		   {
			String sql="select * from member where email=? ";
		      
		   	
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      boolean check = false;
		      try
		      {
		    	  con=DBUtil.getConnect();
			      ptmt=con.prepareStatement(sql);
			      ptmt.setString(1,email);
			      rs=ptmt.executeQuery();
			      if(rs.next())
			      {
			    	  check = true;
			      }
		      }
		   
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(rs, ptmt, con);   
		      }
		      return check;
		   }	
		
		/*
		
		
		public int delete(String id)
		   {
		      String sql="delete from member where id=?";
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      int result=0;
		      try
		      {
		         con=DBUtil.getConnection();
		         
		         ptmt=con.prepareStatement(sql);
		         ptmt.setString(1,id);
		       
		         
		         result=ptmt.executeUpdate();
		      
		      }
		      catch(SQLException e)
		      {
		         e.printStackTrace();
		      }
		      finally
		      {
		         DBUtil.close(null, ptmt, con);   
		      }   
		      return result;
		   }
		*/
		
/*		public ArrayList<MemberDTO> showAll()
		   {
		      String sql="select * from member";
		      
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
		      MemberDTO user=null;
		      try
		      {
		         con=DBUtil.getConnection();
		         ptmt=con.prepareStatement(sql);
		         
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		            user=new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));
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
		
		public ArrayList<MemberDTO> findByAddrMenu(String addr)
		   {
		      String sql="select * from member where addr like ?";
		      Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
		      MemberDTO user=null;
		      try
		      {
		         con=DBUtil.getConnection();
		         ptmt=con.prepareStatement(sql);
		         
		         ptmt.setString(1,"%"+addr+"%");
		         
		         rs=ptmt.executeQuery();
		         while(rs.next())
		         {
		            user=new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));
		            list.add(user);
		         }
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
	
		
		public MemberDTO login(String id,String pass)
		   {
		      String sql="select * from member where id=? and pass=?";
		      
		   	
		      MemberDTO user=null;
			  Connection con=null;
		      PreparedStatement ptmt = null;
		      ResultSet rs=null;
		      try
		      {
		    	  con=DBUtil.getConnection();
			      ptmt=con.prepareStatement(sql);
			      ptmt.setString(1,id);
			      ptmt.setString(2,pass);
			      rs=ptmt.executeQuery();
			      if(rs.next())
			      {
			    	  user=new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3)
		                  ,rs.getString(4),rs.getDate(5),rs.getInt(6),rs.getString(7));  
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
	*/
	

}
