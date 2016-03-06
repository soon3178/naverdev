package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "logoutgo", urlPatterns = { "/logout.do" })
public class logoutgo extends HttpServlet {
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
   {
        HttpSession ses = request.getSession(false);
        if(ses!=null)
        {
           ses.invalidate();
        }
        RequestDispatcher son = request.getRequestDispatcher("/main/mainTemplet.jsp");
         son.forward(request, response);
   }

}
