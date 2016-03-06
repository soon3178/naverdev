package musician;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceDAO;
import service.ServiceDTO;
import music.MusicDAO;
import music.MusicDTO;


@WebServlet(name = "MusicianList", urlPatterns = { "/MusicianList.do" })
public class MusicianListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MusicianDAO dao=new MusicianDAO();
		ArrayList<MusicianDTO> list = dao.selectAll();
		String pathurl = request.getParameter("pathurl");
		
		request.setAttribute("pathurl", pathurl);//Ãß°¡
		request.setAttribute("list", list);					///manager/musicianList.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
		

		System.out.println(pathurl);
	
	}

}


