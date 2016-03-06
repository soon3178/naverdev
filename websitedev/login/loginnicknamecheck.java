package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "loginnicknamecheck", urlPatterns = { "/loginnicknamecheck.do" })
public class loginnicknamecheck extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		String nickname = request.getParameter("nickname");
		System.out.println(nickname);
		MemberDAO user =new MemberDAO();
		boolean check=true;
		check=user.nickcheck(nickname);
		String chk="";
		if(check == true)
		{
			chk="ok";
		}
		else
		{
			chk="no";
		}
		System.out.println(chk);
		request.setAttribute("check", chk);
		
		RequestDispatcher son = request.getRequestDispatcher("/member/nickcheck.jsp");
		son.forward(request, response);
		
	}

	

}
