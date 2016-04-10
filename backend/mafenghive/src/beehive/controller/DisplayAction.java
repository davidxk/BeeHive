package beehive.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beehive.bean.Report;
import beehive.bean.User;
import beehive.dao.ReportDao;

public class DisplayAction extends HttpServlet {
	private ReportDao reportDao = new ReportDao();
	public DisplayAction() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = (User)request.getAttribute("user");
		
		String choice = request.getParameter("choice");
		List<Report> reports = null;
		if(choice == null);
			//reports = reportDao.getLatestReport(user.getPhone(), 30);
		else if(choice == "latest")
		{
			//request.getParameter("days");
			//reports = reportDao.getLatestReport(user.getPhone(), 30);
		}
		else if(choice == "all");
			//reports = reportDao.getAll(user.phone);
		else if(choice == "timed")
		{
			Date start = (Date)request.getAttribute("start_time");
			Date end = (Date)request.getAttribute("end_time");
			//reports = reportDao.getTimedReport(user.phone, start, end);
		}
		request.setAttribute("reports", reports);
		request.getRequestDispatcher("../display_page.jsp").forward(request, response);		
	}
}
