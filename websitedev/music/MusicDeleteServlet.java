package music;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "MusicDelete", urlPatterns = { "/MusicDelete.do" })
public class MusicDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicID = request.getParameter("musicID");
		MusicDAO dao = new MusicDAO();
		int result = dao.deleteMusic(musicID);
		
		response.sendRedirect("/MinerG/MusicList.do");
	}

}
