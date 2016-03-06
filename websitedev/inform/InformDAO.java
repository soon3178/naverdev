package inform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBUtil.DBUtil;

public class InformDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<InformDTO> chart(){
		ArrayList<InformDTO> list = new ArrayList<InformDTO>();
		try{
			String sql="select  musicID,m.musicianID,m.albumID,genre,team,release,musicName, musicianName,albumName,gender,musicVideo,musicRoute,playtime "
					+ "from music m,musician mc,album a "
					+ "where m.musicianID=mc.musicianID and m.albumID=a.albumID";
			con=DBUtil.getConnect();
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				InformDTO inform = new InformDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
				list.add(inform);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	public ArrayList<InformDTO> inform(String musicID){
		ArrayList<InformDTO> list = new ArrayList<InformDTO>();
		try{
			
			String sql="select  musicID,m.musicianID,m.albumID,genre,team,release,musicName, musicianName,albumName,gender,musicVideo,musicRoute,playtime "
					+ "from music m,musician mc,album a "
					+ "where m.musicianID=mc.musicianID and m.albumID=a.albumID and musicID in()";
			con=DBUtil.getConnect();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, musicID);
			rs=pstmt.executeQuery();
			while(rs.next()){
					InformDTO inform = new InformDTO(rs.getString(1),rs.getString(2),rs.getString(3),
							rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
					list.add(inform);
				}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	public ArrayList<InformDTO> informArr(String[] music){
		ArrayList<InformDTO> list = new ArrayList<InformDTO>();
		try{
			
			String url="";
			
			for(int i=0;i<music.length;i++){
				if(music.length==1){
					url="'"+music[i]+"'";
				}
				else if(i==0){
					url="'"+music[i]+"',";
				}
				
				else if(i==music.length-1){
					url=url+"'"+music[i]+"'";
				}
				else{
					url=url+"'"+music[i]+"',";
				}
				
			}
			System.out.println(url);
			String sql="select  musicID,m.musicianID,m.albumID,genre,team,release,musicName, musicianName,albumName,gender,musicVideo,musicRoute,playtime "
					+ "from music m,musician mc,album a "
					+ "where m.musicianID=mc.musicianID and m.albumID=a.albumID and musicID in("+url+")";
			con=DBUtil.getConnect();
			pstmt=con.prepareStatement(sql);
		//	pstmt.setString(1, url);
			rs=pstmt.executeQuery();
			System.out.println(sql);
			while(rs.next()){
				InformDTO inform = new InformDTO(rs.getString(1),rs.getString(2),rs.getString(3),
						rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getInt(13));
				list.add(inform);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		
		return list;
	}
	
	public ArrayList<InformDTO> album(String musicianID){
		ArrayList<InformDTO> list = new ArrayList<>();
		try{
			String sql="select * from album where musicianID=?";
			con=DBUtil.getConnect();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, musicianID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InformDTO inform = new InformDTO(rs.getString(1),rs.getString(2),rs.getString(3));
				list.add(inform);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	
	public ArrayList<InformDTO> albumTrack(String albumID){
		ArrayList<InformDTO> list = new ArrayList<>();
		try{
			String sql="select musicName,musicianName,albumName,release from music m,musician mc,album a where m.albumID=a.albumId and mc.musicianID=a.musicianID and a.albumID=?";
			con=DBUtil.getConnect();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, albumID);
			rs=pstmt.executeQuery();
			while(rs.next()){
				InformDTO inform = new InformDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
				list.add(inform);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
}
