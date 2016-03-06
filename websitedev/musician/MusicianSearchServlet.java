package musician;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.MusicDAO;
import music.MusicDTO;


@WebServlet(name = "MusicianSearch", urlPatterns = { "/MusicianSearch.do" })
public class MusicianSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String select = request.getParameter("select");
		String search = request.getParameter("search");
		
		MusicianDAO dao = new MusicianDAO();
		ArrayList<MusicianDTO> list = dao.select(select,search);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/musicianList.jsp");
		rd.forward(request, response);
	}

}
