package beehive.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends HttpServlet {

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
		//if(!UserDAO.has(phone))

		// Call ReportDao to get the object
		//user = UserDAO.get(phone);
		//if(password == user.password)
		// Forward to DisplayAction
		//else
		// Forward to password error page
	}
}
