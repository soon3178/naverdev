package bane;
import login.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "bane", urlPatterns = { "/bane.do" })

public class bane extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pathurl=request.getParameter("pathurl");
		String id=request.getParameter("id");
		MemberDAO user= new MemberDAO();
		MemberDTO dto = new MemberDTO();;
		dto=user.idcheck1(id);
		
		HttpSession ses = request.getSession();
		ses.setAttribute("user",dto);
		
		request.setAttribute("pathurl", pathurl);
		RequestDispatcher son =request.getRequestDispatcher("/main/mainTemplet.jsp");
		son.forward(request, response);
	}
	
	
}


	
