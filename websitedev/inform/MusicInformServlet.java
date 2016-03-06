package inform;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MusicInform", urlPatterns = { "/MusicInform.do" })
public class MusicInformServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=UTF-8");
	
		String musicID = request.getParameter("musicID");
		String musicianID = request.getParameter("musicianID");
		String albumID = request.getParameter("albumID");
		String pathurl=request.getParameter("pathurl");
		pathurl = pathurl+"information/musicInformation.jsp";
		//기본 아티스트 정보
		InformDAO dao = new InformDAO();
		ArrayList<InformDTO> list = dao.inform(musicID);
		request.setAttribute("list", list);
		//앨범 정보
		ArrayList<InformDTO> albumList = dao.album(musicianID);
		request.setAttribute("albumList", albumList);
		//앨범 트랙 정보
		ArrayList<InformDTO> albumTrack = dao.albumTrack(albumID);
		request.setAttribute("albumTrack", albumTrack);
		request.setAttribute("pathurl", pathurl);
		
		RequestDispatcher rd = request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
	}

}
