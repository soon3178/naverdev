package service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.MusicDTO;


@WebServlet(name = "ServiceList", urlPatterns = { "/ServiceList.do" })
public class ServiceListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceDAO dao=new ServiceDAO();
		ArrayList<ServiceDTO> list = dao.selectAll();
		String pathurl = request.getParameter("pathurl");
		
		request.setAttribute("pathurl", pathurl);
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
	}

}
