package music;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MusicSearch", urlPatterns = { "/MusicSearch.do" })
public class MusicSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String select = request.getParameter("select");
		String search = request.getParameter("search");
		
		MusicDAO dao = new MusicDAO();
		ArrayList<MusicDTO> list = dao.select(select,search);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/musicList.jsp");
		rd.forward(request, response);
	}

}
