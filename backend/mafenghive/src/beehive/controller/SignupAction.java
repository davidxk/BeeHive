package beehive.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beehive.bean.User;

public class SignupAction extends HttpServlet {

	public SignupAction() {
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
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");

		// If user phone exists, forward to UsrExists
		//if(UserDAO.has(phone))

		// Initiate a Report object
		User user = new User(phone, nickname, password);

		// Call ReportDao to save the object
		//UserDAO.save(user);

		// Forward to DisplayAction
	}

}
