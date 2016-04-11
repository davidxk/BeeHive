package beehive.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beehive.bean.*;
import beehive.dao.ReportDao;

public class displayServ extends HttpServlet {
	public class ChartPoint
	{
		public ChartPoint(String x, float y)
		{
			this.x = x;
			this.y = y;
		}
		public float y;
		public String x;
	}
	
	private ReportDao reportDao = new ReportDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String device = request.getParameter("device");
        response.setContentType("image/jpeg");
		JFreeChart chart = null;
		final int N_KEYS = 5;
		final String keys[] = { "co", "temperature", "humidity", "noise", "ultraviolet" };
		final String rangeAxisLabels[] = { "density", "Celsius degree", 
			"decibel", "%", "Vol" };
		for(int i=0; i<N_KEYS; i++)
			if(device.equals(keys[i]))
			{
				List<Report> reports = getReport(request);
				DefaultCategoryDataset dataset = createDataset(keys[i], getSpecifiedAttribute(keys[i], reports));
				chart = createChart(dataset, keys[i]+" situation", rangeAxisLabels[i]);
				break;
			}
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(),chart,800,600);
    }

	private List<Report> getReport(HttpServletRequest request) 
	{
		List<Report> reports = null;
		User user = (User) request.getSession().getAttribute("user");
		String choice = request.getParameter("choice");
		String phone = (String) request.getAttribute("phone");

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

	// Create chart object JFreeChart
    private JFreeChart createChart(DefaultCategoryDataset linedataset, String chartTitle, String rangeAxisLabel) 
	{
        //定义图表对象
        JFreeChart chart = ChartFactory.createLineChart(chartTitle, // chart title
                "time", // domain axis label
				rangeAxisLabel, // range axis label
                linedataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );
        CategoryPlot plot = chart.getCategoryPlot();
        // customise the range axis...
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);
        rangeAxis.setUpperMargin(0.20);
        //rangeAxis.setLabelAngle(Math.PI / 2.0);
        return chart;
    }
	
    // Create Dataset
    private DefaultCategoryDataset createDataset(String series, List<ChartPoint> pointSet) 
	{
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		for(ChartPoint point: pointSet)
			linedataset.addValue(point.y, series, point.x);

        return linedataset;
    }
	private List<ChartPoint> getSpecifiedAttribute(String key, List<Report> reports)
	{
		List<ChartPoint> pointSet = new ArrayList<ChartPoint>();
		for(Report report: reports)
			switch(key.charAt(0))
			{
				case 'c': pointSet.add(new ChartPoint(report.timestamp.toString(), report.co)); break;
				case 't': pointSet.add(new ChartPoint(report.timestamp.toString(), report.temperature)); break;
				case 'h': pointSet.add(new ChartPoint(report.timestamp.toString(), report.humidity)); break;
				case 'n': pointSet.add(new ChartPoint(report.timestamp.toString(), report.noise)); break;
				case 'u': pointSet.add(new ChartPoint(report.timestamp.toString(), report.ultraviolet)); break;
			}
		return pointSet;
	}
}
