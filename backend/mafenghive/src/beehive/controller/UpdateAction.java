package beehive.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beehive.bean.*;
import beehive.dao.*;


public class UpdateAction extends HttpServlet {


	private UserDao userDao = new UserDao();
	private SwitchDao switchDao = new SwitchDao();
	public UpdateAction() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// Read report data from <form>

		// Initiate a Report object
		int isOn = Integer.parseInt(request.getParameter("ison"));

		// Call ReportDao to save the object
		switchDao.updateStatus(isOn);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
