package payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.MemberDAO;
import login.MemberDTO;
import service.ServiceDAO;
import service.ServiceDTO;

@WebServlet(name = "payment", urlPatterns = { "/payment.do" })

public class PaymentServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		HttpSession ses = request.getSession();
		
		MemberDTO memberDTO= (MemberDTO)ses.getAttribute("user");
		System.out.println(memberDTO.getMemberid());
		String serviceID = (String) request.getParameter("id");
		String pathurl = "";
		if(serviceID.equals("M01")){
			pathurl ="../product/payment_m01.jsp";
		}
		else if(serviceID.equals("M03")){
			pathurl ="../product/payment_m03.jsp";
		}
		else if(serviceID.equals("cash")){
			pathurl ="../product/payment_cash.jsp";
		}
		
		request.setAttribute("pathurl", pathurl);
		
		RequestDispatcher son = request.getRequestDispatcher("/main/mainTemplet.jsp");
		son.forward(request, response);

		
		
	}
}
