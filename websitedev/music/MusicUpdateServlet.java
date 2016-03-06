package music;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MusicUpdate", urlPatterns = { "/MusicUpdate.do" })
public class MusicUpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		String musicID = request.getParameter("musicID");
		String musicName = request.getParameter("musicName");
		String musicianID = request.getParameter("musicianID");
		String albumID = request.getParameter("albumID");
		String genre = request.getParameter("genre");
		int playtime = Integer.parseInt(request.getParameter("playTime"));
		String musicvideo = request.getParameter("musicvideo");
		String musicRoute = request.getParameter("musicRoute");
		
		MusicDTO music = new MusicDTO(musicID, musicName, musicianID, albumID, genre, playtime, musicvideo, musicRoute);
		MusicDAO dao = new MusicDAO();
		
		int result=dao.updateMusic(music);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/musicUpdate.jsp");
		rd.forward(request, response);
	}

}
