package music;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MusicList", urlPatterns = { "/MusicList.do" })
public class MusicListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MusicDAO dao=new MusicDAO();
		ArrayList<MusicDTO> list = dao.selectAll();
		String pathurl = request.getParameter("pathurl");
		
		request.setAttribute("list", list);
		request.setAttribute("pathurl", pathurl);
		System.out.println(pathurl);
		RequestDispatcher rd = request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
		
		

		
	
		
		
	}

}
