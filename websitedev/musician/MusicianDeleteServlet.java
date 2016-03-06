package musician;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.MusicDAO;

@WebServlet(name = "MusicianDelete", urlPatterns = { "/MusicianDelete.do" })
public class MusicianDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicianID = request.getParameter("musicianID");
		MusicianDAO dao = new MusicianDAO();
		int result = dao.deleteMusician(musicianID);
		
		response.sendRedirect("/MinerG/MusicianList.do");	
	}

}
