package music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBUtil.DBUtil;



public class MusicDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertMusic(MusicDTO dto) {
		int result=0;
		try{		
			con=DBUtil.getConnect();
			String sql = "insert into music values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getMusicID());
			pstmt.setString(2, dto.getMusicName());
			pstmt.setString(3, dto.getMusicianID());
			pstmt.setString(4, dto.getAlbumID());
			pstmt.setString(5, dto.getGenre());
			pstmt.setInt(6, dto.getPlayTime());
			pstmt.setString(7, dto.getMusicvideo());
			pstmt.setString(8, dto.getMusicRoute());
		
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);	
		}return result;
	}
	
	public int updateMusic(MusicDTO dto){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "update music set musicName=?,musicianID=?,albumID=?,genre=?,playTime=?,"
					+ "musicvideo=?,musicRoute=? where musicID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getMusicName());
			pstmt.setString(2, dto.getMusicianID());
			pstmt.setString(3, dto.getAlbumID());
			pstmt.setString(4, dto.getGenre());
			pstmt.setInt(5, dto.getPlayTime());
			pstmt.setString(6, dto.getMusicvideo());
			pstmt.setString(7, dto.getMusicRoute());
			pstmt.setString(8, dto.getMusicID());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}return result;
	}
	
	public int deleteMusic(String musicID){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "delete from music where musicID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, musicID);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}
		return result;
	}
	
	public ArrayList<MusicDTO> selectAll(){
		ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
		try{
			con=DBUtil.getConnect();
			String sql = "select * from music";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MusicDTO music = new MusicDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getInt(6),rs.getString(7),rs.getString(8));
				list.add(music);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	public ArrayList<MusicDTO> select(String select, String search){
		ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
		try{
			con=DBUtil.getConnect();
			if(select.equals("musicID")){
				String sql = "select * from music where musicID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}else if(select.equals("musicName")){
				String sql = "select * from music where musicName=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}else if(select.equals("musicianID")){
				String sql = "select * from music where musicianID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}else{
				String sql = "select * from music where musicianID="
						+ "(select distinct musicianID from musician where musicianName=?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				MusicDTO music = new MusicDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getInt(6),rs.getString(7),rs.getString(8));
				list.add(music);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
}
