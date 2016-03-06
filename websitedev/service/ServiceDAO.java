package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBUtil.DBUtil;

public class ServiceDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public int insertService(ServiceDTO dto) {
		int result=0;
		try{		
			con=DBUtil.getConnect();
			String sql = "insert into service values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getServiceID());
			pstmt.setString(2, dto.getServiceName());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getPeriod());
			pstmt.setInt(5, dto.getDownload());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);	
		}return result;
	}
	
	public int updateService(ServiceDTO dto){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "update service set serviceName=?,price=?,period=?,download=? where serviceID=?";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getServiceName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getPeriod());
			pstmt.setInt(4, dto.getDownload());
			pstmt.setString(5, dto.getServiceID());
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}return result;
	}
	
	public int deleteService(String serviceID){
		int result=0;
		try{
			con=DBUtil.getConnect();
			String sql = "delete from service where serviceID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, serviceID);
			result=pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);
		}
		return result;
	}
	
	public ArrayList<ServiceDTO> selectAll(){
		ArrayList<ServiceDTO> list = new ArrayList<ServiceDTO>();
		try{
			con=DBUtil.getConnect();
			String sql = "select * from service";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ServiceDTO service = new ServiceDTO(rs.getString(1),rs.getString(2),
						rs.getInt(3),rs.getInt(4),rs.getInt(5));
				list.add(service);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	
}
