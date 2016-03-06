package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
@WebServlet(name = "logingo", urlPatterns = { "/logingo.do" })

public class MemberInsertServlet extends HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		req.setCharacterEncoding("euc-kr");
		res.setContentType("text/html;charset=euc-kr");
		PrintWriter out = res.getWriter();

		String nickname = req.getParameter("nickname");
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		
		
		System.out.println("aa");
		
		MemberDAO user =new MemberDAO();
		MemberDTO dto =new MemberDTO(id,pass,nickname,email);
		
		user.insert(dto);
		
		int result=user.insert(dto);
		
		req.setAttribute("result", result);
		
		RequestDispatcher son = req.getRequestDispatcher("/main/mainTemplet.jsp");
		son.forward(req, res);
		
		
	}
}