package payment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.MemberDAO;
import login.MemberDTO;

@WebServlet("/pay_result.do")
public class PaymentResult extends HttpServlet {
	public void payResult(int result, HttpServletResponse response) throws ServletException, IOException{
		if(result != 0){
			response.sendRedirect("/MinerG/main/mainTemplet.jsp");
		}
		else{
			response.sendRedirect("/MinerG/product/payment_error.jsp");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession ses = request.getSession();
		
		MemberDTO memberDTO= (MemberDTO)ses.getAttribute("user");
		String kind = request.getParameter("kind");
		
		MemberDAO memberDAO = new MemberDAO();
		int point=0, result=0;
		
		if(kind.equals("m01")){
			point = memberDTO.getPoint()-4000;
			System.out.println(point);
			result = memberDAO.pointmodify(memberDTO.getMemberid(), point);
			payResult(result, response);
		}
		else if(kind.equals("m03")){
			point = memberDTO.getPoint()-10000;
			System.out.println(point);
			result = memberDAO.pointmodify(memberDTO.getMemberid(), point);
			payResult(result, response);
		}
		else{
			int charge = Integer.parseInt(request.getParameter("charge"));
			System.out.println(charge);
			point = memberDTO.getPoint()+charge;
			System.out.println(point);
			result = memberDAO.pointmodify(memberDTO.getMemberid(), point);
			payResult(result, response);
		}		
	}
}
