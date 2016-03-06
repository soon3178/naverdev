package bane;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.MemberDAO;
import login.MemberDTO;

@WebServlet(name = "beneservelt", urlPatterns = { "/beneservelt.do" })

public class baneservelt extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pathurl=request.getParameter("pathurl");
		String id=request.getParameter("id");
		MemberDAO user= new MemberDAO();
		MemberDTO dto = new MemberDTO();;
		dto=user.idcheck1(id);
		int point =0;
		point = dto.getPoint()+50;
		user.pointmodify(id, point);
		
		HttpSession ses = request.getSession();
		ses.setAttribute("user",dto);
		
		request.setAttribute("pathurl", pathurl);
		RequestDispatcher son =request.getRequestDispatcher("/main/mainTemplet.jsp");
		son.forward(request, response);
	}

	

}
