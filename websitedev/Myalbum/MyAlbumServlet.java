package Myalbum;
import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ViewServlet
 */
@WebServlet(name = "myalbum", urlPatterns = { "/myalbum.do" })
public class MyAlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		String pathurl=request.getParameter("pathurl");
		String pathurl1="../myalbum/myalbumdown.jsp";
		pathurl = pathurl+"myalbum/myalbum.jsp";
		
		request.setAttribute("pathurl", pathurl);
		request.setAttribute("pathurl1", pathurl1);
		
		
		
		
		MymusicDTO user =new MymusicDTO();
		ArrayList<MymusicDTO> list=new ArrayList<MymusicDTO>();
		
		MymusicDAO user1 = new MymusicDAO();
		list=user1.findMymusic("1");
		
	
		
		request.setAttribute("userlist",list);
		RequestDispatcher rd=request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
	
		///////////////////////////////////////////
		
	}

	

}
