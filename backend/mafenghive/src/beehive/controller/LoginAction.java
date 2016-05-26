package beehive.controller;

import java.io.IOException;
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
		String phone = request.getParameter("phone");
		String password = request.getParameter("password"); 
		// If user phone not exist, forward to UsrNotExist
		if(userDao == null)
		{
			response.sendRedirect("./page_not_found.jsp");
			return;
		}
		if(!userDao.has(phone))
		{
			response.sendRedirect("./user_not_found.jsp");
			return;
		}

		// Call ReportDao to get the object
		
		User user = userDao.getUser(phone);
		request.setAttribute("user", user);
		request.getSession().setAttribute("user", user);
		if( password.equals(user.getPassword()) )
			response.sendRedirect("DisplayAction");
			//request.getRequestDispatcher("DisplayAction").forward(request, response);
		else
			response.sendRedirect("./user_not_found.jsp");
	}
}
