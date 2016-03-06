package musician;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import music.MusicDTO;
import DBUtil.DBUtil;

public class MusicianDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertMusician(MusicianDTO dto) {
		int result=0;
		try{		
			con=DBUtil.getConnect();
			String sql = "insert into musician values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getMusicianID());
			pstmt.setString(2, dto.getMusicianName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getTeam());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);	
		}return result;
	}
	
	public int updateMusician(MusicianDTO dto){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "update musician set musicianName=?,gender=?,team=? where musicianID=?";
			
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1, dto.getMusicianName());
			pstmt.setString(2, dto.getGender());
			pstmt.setString(3, dto.getTeam());
			pstmt.setString(4, dto.getMusicianID());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}return result;
	}
	
	public int deleteMusician(String musicianID){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "delete from musician where musicianID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, musicianID);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}
		return result;
	}
	
	public ArrayList<MusicianDTO> selectAll(){
		ArrayList<MusicianDTO> list = new ArrayList<MusicianDTO>();
		try{
			con=DBUtil.getConnect();
			String sql = "select * from musician";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				MusicianDTO musician = new MusicianDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(musician);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<MusicianDTO> select(String select, String search) {
		ArrayList<MusicianDTO> list = new ArrayList<MusicianDTO>();
		try{
			con=DBUtil.getConnect();
			if(select.equals("musicianID")){
				String sql = "select * from musician where musicianID=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}else if(select.equals("musicianName")){
				String sql = "select * from musician where musicianName=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, search);
			}
			rs = pstmt.executeQuery();
			while(rs.next()){
				MusicianDTO musician = new MusicianDTO(rs.getString(1),rs.getString(2),
						rs.getString(3),rs.getString(4));
				list.add(musician);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	
}
