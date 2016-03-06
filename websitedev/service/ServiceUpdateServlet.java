package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServiceUpdate", urlPatterns = { "/ServiceUpdate.do" })
public class ServiceUpdateServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		String serviceID = request.getParameter("serviceID");
		String serviceName = request.getParameter("serviceName");
		int price = Integer.parseInt(request.getParameter("price"));
		int period = Integer.parseInt(request.getParameter("period"));
		int download = Integer.parseInt(request.getParameter("download"));
		
		ServiceDTO service = new ServiceDTO(serviceID, serviceName, price, period,download);
		ServiceDAO dao = new ServiceDAO();
		int result=dao.updateService(service);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/main/mainTemplet.jsp");
		rd.forward(request, response);
	}

}
