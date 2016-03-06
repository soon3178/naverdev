package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import music.MusicDAO;

@WebServlet(name = "ServiceDelete", urlPatterns = { "/ServiceDelete.do" })
public class ServiceDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String serviceID = request.getParameter("serviceID");
		ServiceDAO dao = new ServiceDAO();
		int result = dao.deleteService(serviceID);
		
		response.sendRedirect("/MinerG/ServiceList.do");
	
	}

}
