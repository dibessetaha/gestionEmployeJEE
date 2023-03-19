package com.webproject.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.webproject.bdd.Users;
import com.webproject.beans.User;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static User user = new User() ; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpSession session = request.getSession() ; 
		  session.invalidate() ; 
		  this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username") ; 
		String password = request.getParameter("password") ; 
		Users tableNoms = new Users() ; 
		List<User> listUsers = tableNoms.getUsers()  ; 

		 for (int i = 0; i < listUsers.size(); i++) {
		      if(listUsers.get(i).isValidPass(username, password)) {
		    	  if(listUsers.get(i).getRole().equals("admin")) {
		    		  user = listUsers.get(i) ; 
		    		  request.setAttribute("user", listUsers.get(i));
		    		  HttpSession session = request.getSession() ; 
		    			session.setAttribute("username", listUsers.get(i).getUsername());
		    			session.setAttribute("password", listUsers.get(i).getPassword());
		    		  this.getServletContext().getRequestDispatcher("/Users/Admin/AdminDashboard.jsp").forward(request, response); 		    		  
		    	  }else if(listUsers.get(i).getRole().equals("emp")) {
		    		  user = listUsers.get(i) ; 
		    		  request.setAttribute("user", listUsers.get(i));
		    		  HttpSession session = request.getSession() ; 
		    			session.setAttribute("username", listUsers.get(i).getUsername());
		    			session.setAttribute("password", listUsers.get(i).getPassword());
		    		  this.getServletContext().getRequestDispatcher("/Users/Employe/empDashboard.jsp").forward(request, response); 		    		  
		    	  }else {
		    		  user = listUsers.get(i) ; 
		    		  request.setAttribute("user", listUsers.get(i));
		    		  HttpSession session = request.getSession() ; 
		    			session.setAttribute("username", listUsers.get(i).getUsername());
		    			session.setAttribute("password", listUsers.get(i).getPassword());
		    		  this.getServletContext().getRequestDispatcher("/Users/RH/rhDashboard.jsp").forward(request, response); 		
		    	  }
		    	  
		      }
	
		      
		 }
		 	request.setAttribute("error", "Les indentifiants sont incorrect");
			this.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 


	}

}
