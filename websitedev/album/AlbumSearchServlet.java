package album;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musician.MusicianDAO;
import musician.MusicianDTO;

@WebServlet(name = "AlbumSearch", urlPatterns = { "/AlbumSearch.do" })
public class AlbumSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String select = request.getParameter("select");
		String search = request.getParameter("search");
		
		AlbumDAO dao = new AlbumDAO();
		ArrayList<AlbumDTO> list = dao.select(select,search);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/albumList.jsp");
		rd.forward(request, response);
	}

}
