package Myalbum;

import inform.InformDAO;
import inform.InformDTO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MyAlbumListen", urlPatterns = { "/MyAlbumListen.do" })
public class MyAlbumListenServlet extends HttpServlet {

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
		
		RequestDispatcher rd = request.getRequestDispatcher("/chart/popup.jsp");
		rd.forward(request, response);
	}

}
