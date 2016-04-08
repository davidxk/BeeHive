package beehive.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beehive.dao.UserDao;
import beehive.bean.User;

public class LoginAction extends HttpServlet {

	private UserDao userDao = new UserDao();
	public LoginAction() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// Read report data from <form>
		int phone = Integer.parseInt( request.getParameter("phone") );
		String password = request.getParameter("password"); 
		// If user phone not exist, forward to UsrNotExist
		if(userDao == null)
		{
			response.sendRedirect("../page_not_found.jsp");
			return;
		}
		if(!userDao.has(phone))
		{
			response.sendRedirect("../user_not_found.jsp");
			return;
		}

		// Call ReportDao to get the object
		User user = userDao.getUser(phone);
		if( password.equals(user.getPassword()) )
			response.sendRedirect("DisplayAction");
		else
			response.sendRedirect("../user_not_found.jsp");
	}
}
