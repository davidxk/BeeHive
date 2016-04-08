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
import beehive.dao.ReportDao;
import beehive.dao.UserDao;

public class SaveAction extends HttpServlet {

	/**
	 *
	 */
	private UserDao userDao = new UserDao();
	private ReportDao reportDao = new ReportDao();
	public SaveAction() {
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
		String keys[] = { "pho", "co1", "tem", "hum", "noi", "ult" };
		Vector<String> values = new Vector<String>();
		for(String key: keys)
			values.add( request.getParameter(key) );
		
		// If user phone not exist, return
		String phone = values.get(0);
		if(!userDao.has(phone))
			return;

		// Initiate a Report object
		Date timestamp = new Date();
		Report report = new Report(phone, timestamp,
				Float.parseFloat(values.get(1)),
				Float.parseFloat(values.get(2)),
				Float.parseFloat(values.get(3)),
				Float.parseFloat(values.get(4)),
				Float.parseFloat(values.get(5))
				);

		// Call ReportDao to save the object
		reportDao.save(report);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
