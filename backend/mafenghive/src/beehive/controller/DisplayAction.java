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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = (User)request.getAttribute("user");
		
		String choice = request.getParameter("choice");
		List<Report> reports = null;
		if(choice == null)
			reports = reportDao.getLatestReport(user.getPhone(), 30);
		else if(choice.equals("latest"))
		{
			request.getParameter("days");
			reports = reportDao.getLatestReport(user.getPhone(), 30);
		}
		else if(choice.equals("all"));
			//reports = reportDao.getAll(user.phone);
		else if(choice.equals("timed"))
		{
			Date start = (Date)request.getAttribute("start_time");
			Date end = (Date)request.getAttribute("end_time");
			reports = reportDao.getTimedReport(user.phone, start.toString(), end.toString());
		}
		request.setAttribute("reports", reports);
		*/
		
		List<Report> reports = getReport(request);
		request.getSession().setAttribute("reports", reports);
		request.setAttribute("reports", reports);
		request.getRequestDispatcher("./display_page.jsp").forward(request, response);		
	}
	
	private List<Report> getReport(HttpServletRequest request) 
	{
		List<Report> reports = null;
		//User user = (User) request.getSession().getAttribute("user");
		User user = (User) request.getSession().getAttribute("user");
		String choice = request.getParameter("choice");
		String phone = user.getPhone();

		if(choice == null)
			reports = reportDao.getLatestReport(phone, 30);
		else if(choice.equals("latest"))
		{
			request.getParameter("days");
			reports = reportDao.getLatestReport(phone, 30);
		}
		else if(choice.equals("all"));
			//reports = reportDao.getAll(user.phone);
		else if(choice.equals("timed"))
		{
			Date start = (Date)request.getAttribute("start_time");
			Date end = (Date)request.getAttribute("end_time");
			reports = reportDao.getTimedReport(phone, start.toString(), end.toString());
		}
		return reports;
	}
}
