package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logincheck", urlPatterns = { "/logincheck.do" })
public class logincheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDAO user =new MemberDAO();
		MemberDTO idcheck =new MemberDTO();
		
		idcheck=user.login(id, pass);
		
		
		HttpSession ses = request.getSession();
		ses.setAttribute("user",idcheck);
	    RequestDispatcher son = request.getRequestDispatcher("/main/mainTemplet.jsp");
	    son.forward(request, response);
	
	}

}
