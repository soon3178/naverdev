package searchmusic;

import musician.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import album.AlbumDAO;
import album.AlbumDTO;
@WebServlet(name = "musicgo", urlPatterns = { "/musicgo.do" })
public class SearchServlet extends HttpServlet {
	
	
	
	
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		String pathurl=request.getParameter("pathurl");
		String pathurl1="../search/searchdown.jsp";
		pathurl = pathurl+"search/search.jsp";
		request.setAttribute("pathurl", pathurl);
		
		request.setAttribute("pathurl1", pathurl1);
		
		String word = request.getParameter("word");
		String genre = request.getParameter("genre");
		
		MusicDAO user =new MusicDAO();
		ArrayList<MusicDTO> list=new ArrayList<MusicDTO>();
		ArrayList<MusicDTO> list2=new ArrayList<MusicDTO>();
		MusicDTO music = null;
		
		MusicianDTO musician = null; 
		MusicianDTO musician1 = null; 
		ArrayList<MusicianDTO> list1=new ArrayList<MusicianDTO>();
	//////////////////////////////////////////////////////////////	
		ArrayList<AlbumDTO> list3=new ArrayList<AlbumDTO>();
		ArrayList<AlbumDTO> list4=new ArrayList<AlbumDTO>();
		AlbumDTO album1 = null;
		AlbumDAO albumgo = null;
	//////////////////////////////////////////////////////////////	
		searchmusician find = new searchmusician();
		
		String[] array = null;
		
		if(genre ==null)
		{
			
		}
		else
		{
			if(genre.equals("MUSICNAME"))
			{
				if(word==null)
				{
				}
				else
				{
					
					list=user.findMusic1(word);
					
					for(int i=0;i<list.size();i++)
					{
						musician = find.findMusicianDTO(list.get(i).getMusicianid());
						list1.add(musician);
						System.out.println(list.get(i).getAlbumid());
					}
					
				}
			}
			else
			{
				if(word==null)
				{
				
				
				}
				else
				{
					list1=find.findMusicianDTO1(word);
					for(int i=0;i<list1.size();i++)
					{
						musician = list1.get(i);
						list2 = user.findMusic3(musician.getMusicianID());
						//list4 = albumgo.select("musicianID",musician.getMusicianID().toUpperCase());
						for(int j=0;j<list2.size();j++)
						{
							list.add(list2.get(j));
							
						}
					}	
					
				}
				
			}
		}
	
		

	
		
		
		
		//request.setAttribute("userlist2",list4);
		request.setAttribute("userlist1",list1);
		request.setAttribute("userlist",list);
		RequestDispatcher son = request.getRequestDispatcher("/main/mainTemplet.jsp");
		son.forward(request, response);
	}


		
	
}

