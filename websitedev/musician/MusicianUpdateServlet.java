package musician;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.MusicDAO;
import music.MusicDTO;


@WebServlet(name = "MusicianUpdate", urlPatterns = { "/MusicianUpdate.do" })
public class MusicianUpdateServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		String musicianID = request.getParameter("musicianID");
		String musicianName = request.getParameter("musicianName");
		String gender = request.getParameter("gender");
		String team = request.getParameter("team");
		
		
		MusicianDTO musician = new MusicianDTO(musicianID, musicianName, gender, team);
		MusicianDAO dao = new MusicianDAO();
		
		int result=dao.updateMusician(musician);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/musicianUpdate.jsp");
		rd.forward(request, response);
	}

}
