package beehive.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import beehive.controller.displayServ.ChartPoint;
import beehive.dao.ReportDao;
import beehive.bean.Report;
import beehive.dao.SwitchDao;
import beehive.bean.Switch;
import beehive.dao.UserDao;
import beehive.bean.User;


public class DataAnalyseAction extends HttpServlet {

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
	
	
	
	
	
	
	public DataAnalyseAction() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	
	}
    
   
    private List<Report> getHistoryData(String phone, Date starttime, Date endtime){
    	List<Report> reports = null;
    	return reports;
    }
    
    
    private List<Report> getSameCityData(String city){
    	List<Report> reports = null;
    	return reports;
    }
    
    
    
   
   
   
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
	

		return pointSet;
	}
   
   
   
   
   
}
