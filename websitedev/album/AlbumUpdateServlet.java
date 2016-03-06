package album;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AlbumUpdate", urlPatterns = { "/AlbumUpdate.do" })
public class AlbumUpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		
		
		String albumID = request.getParameter("albumID");
		String albumName = request.getParameter("albumName");
		String gender = request.getParameter("release");
		String team = request.getParameter("musicianID");
		
		
		AlbumDTO album = new AlbumDTO(albumID, albumName, gender, team);
		AlbumDAO dao = new AlbumDAO();
		
		int result=dao.updateAlbum(album);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/manager/albumUpdate.jsp");
		rd.forward(request, response);
	}

}
