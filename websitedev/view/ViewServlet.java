package view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet(name = "view", urlPatterns = { "/view.do" })
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pathurl=request.getParameter("pathurl");
		request.setAttribute("pathurl", pathurl);
		System.out.println(pathurl);
		
		RequestDispatcher rd=request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
	}

	

}
