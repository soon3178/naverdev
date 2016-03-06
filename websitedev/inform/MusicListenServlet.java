package inform;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MusicListen", urlPatterns = { "/MusicListen.do" })
public class MusicListenServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		HttpSession ses = request.getSession(); 
		
		
		InformDAO dao = new InformDAO();
		String[] musicID = request.getParameterValues("musicID");
		ArrayList<InformDTO> list=dao.informArr(musicID);
			//System.out.println(dao.inform(musicID[i]));
			//request.setAttribute("list", list);
			//System.out.println(list);
			
		
		ses.setAttribute("list", list);
		
		//System.out.println(musicID);
		//System.out.println(list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/player/player.jsp");
		rd.forward(request, response);
	}

}
