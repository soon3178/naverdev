package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginemailcheck", urlPatterns = { "/loginemailcheck.do" })

public class loginemailcheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		String email = request.getParameter("email");
		
		MemberDAO user =new MemberDAO();
		boolean check=true;
		check=user.emailcheck(email);
		String chk="";
		if(check == true)
		{
			chk="ok";
		}
		else
		{
			chk="no";
		}
		request.setAttribute("check", chk);
		
		RequestDispatcher son = request.getRequestDispatcher("/member/emailcheck.jsp");
		son.forward(request, response);
	}

	
}
