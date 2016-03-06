package album;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import musician.MusicianDTO;
import DBUtil.DBUtil;

public class AlbumDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertAlbum(AlbumDTO dto) {
		int result=0;
		try{		
			con=DBUtil.getConnect();
			String sql = "insert into album values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getAlbumID());
			pstmt.setString(2, dto.getAlbumName());
			pstmt.setString(3, dto.getRelease());
			pstmt.setString(4, dto.getMusicianID());
			
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);	
		}return result;
	}
	
	public int updateAlbum(AlbumDTO dto){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "update album set albumName=?,release=?,musicianID=? where albumID=?";
			
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1, dto.getAlbumName());
			pstmt.setString(2, dto.getRelease());
			pstmt.setString(3, dto.getMusicianID());
			pstmt.setString(4, dto.getAlbumID());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}return result;
	}
	
	public int deleteAlbum(String albumID){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "delete from album where albumID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, albumID);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}
		return result;
	}
	
	public ArrayList<AlbumDTO> selectAll(){
		ArrayList<AlbumDTO> list = new ArrayList<AlbumDTO>();
		try{
			con=DBUtil.getConnect();
			String sql = "select * from album";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				AlbumDTO album = new AlbumDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(album);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<AlbumDTO> select(String select, String search) {
		ArrayList<AlbumDTO> list = new ArrayList<AlbumDTO>();
		try{
			con=DBUtil.getConnect();
			if(select.equals("albumID")){
				String sql = "select * from album where albumID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search.toUpperCase());
			}else if(select.equals("albumName")){
				String sql = "select * from album where albumName=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				AlbumDTO album = new AlbumDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(album);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	
	
	public ArrayList<AlbumDTO> select1(String select, String search) {
		ArrayList<AlbumDTO> list = new ArrayList<AlbumDTO>();
		try{
			con=DBUtil.getConnect();
			if(select.equals("musicianID")){
				String sql = "select * from album where musicianID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}else if(select.equals("albumName")){
				String sql = "select * from album where albumName=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				AlbumDTO album = new AlbumDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(album);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	
}
