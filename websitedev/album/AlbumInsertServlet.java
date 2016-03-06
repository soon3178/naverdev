package album;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import musician.MusicianDAO;
import musician.MusicianDTO;


@WebServlet(name = "AlbumInsert", urlPatterns = { "/AlbumInsert.do" })
public class AlbumInsertServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		String albumID = request.getParameter("albumID");
		String albumName = request.getParameter("albumName");
		String release = request.getParameter("release");
		String musicianID = request.getParameter("musicianID");
		
		AlbumDTO album = new AlbumDTO(albumID, albumName, release, musicianID);
		AlbumDAO dao = new AlbumDAO();
		int result=dao.insertAlbum(album);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/albumInsert.jsp");
		rd.forward(request, response);
	}

}
