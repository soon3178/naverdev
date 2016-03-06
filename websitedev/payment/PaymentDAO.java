package payment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import service.ServiceDTO;
import DBUtil.DBUtil;

public class PaymentDAO {
	private Connection con=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	public PaymentDAO(){
		super();
	}
	
	public int insertPayment(PaymentDTO dto) {
		int result=0;
		try{		
			con=DBUtil.getConnect();
			String sql = "insert into payment values(payment_seq.nextval,?,?,sysdate)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getServiceID());
			pstmt.setString(2, dto.getMemberID());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, pstmt, con);	
		}return result;
	}
	
	public ArrayList<PaymentDTO> selectAll(){
		ArrayList<PaymentDTO> list = new ArrayList<PaymentDTO>();
		try{
			con=DBUtil.getConnect();
			String sql = "select * from payment";
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				PaymentDTO payment = new PaymentDTO(rs.getString(1),rs.getString(2), rs.getString(3), rs.getDate(4));
				list.add(payment);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return list;
	}
	
	public String search(String id){
		String serviceID="";
		
		try{
			con=DBUtil.getConnect();
			String sql = "select serviceid from payment where memberID=? order by payday";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				serviceID = rs.getString(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, pstmt, con);
		}
		return serviceID;
	}
	
}
