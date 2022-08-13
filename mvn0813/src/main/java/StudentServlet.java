

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import model.*;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonString=request.getParameter("stuData");
		System.out.println(jsonString);
	      GsonBuilder builder = new GsonBuilder(); 
	     // builder.setPrettyPrinting();

	      Gson gson = builder.create(); 
	      Student[ ] student = gson.fromJson(jsonString, Student[ ].class); 	
	      String msg="";
	      for(Student s : student) {
	    	  msg+=s.toString()+"<br/>";
	      }
	      StudentDAO dao=new StudentDAO();
	      dao.addArray(student);
	      response.setContentType("text/html;charset=utf-8");
		  response.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
