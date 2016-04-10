package beehive.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCXYDataset;
import org.jfree.data.time.Month;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Random;

import beehive.bean.*;

public class displayServ extends HttpServlet {
	public class ChartPoint{
		public ChartPoint(String x, float y)
		{
			this.x = x;
			this.y = y;
		}
		public float y;
		public String x;
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String device = request.getParameter("device");
        response.setContentType("image/jpeg");
		JFreeChart chart;
		final int N_KEYS = 5;
		final String keys[] = { "co", "temperature", "humidity", "noise", "ultraviolet" };
		final String rangeAxisLabels[] = {
		   	"density", "Celsius degree", "decibel", "%", "Vol" };
		for(int i=0; i<N_KEYS; i++)
			if(device.equals(keys[i]))
			{
				List<Report> reports = (List<Report>) request.getAttribute("reports");
				DefaultCategoryDataset dataset = createDataset(keys[i], getSpecifiedAttrbute(reports));
				chart = createChart(dataset, keys[i]+" situation", rangeAxisLabels[i]);
				break;
			}
		ChartUtilities.writeChartAsJPEG(response.getOutputStream(),chart,800,600);
    }

	private List<ChartPoint> getSpecifiedAttrbute(List<Report> reports) {
		// TODO Auto-generated method stub
		return null;
	}

	// Create chart object JFreeChart
    public static JFreeChart createChart(DefaultCategoryDataset linedataset, String chartTitle, String rangeAxisLabel) 
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
    public static DefaultCategoryDataset createDataset(String series, List<ChartPoint> pointSet) 
	{
        DefaultCategoryDataset linedataset = new DefaultCategoryDataset();
		for(ChartPoint point: pointSet)
			linedataset.addValue(point.y, series, point.x);

        return linedataset;
    }
	public static List<ChartPoint> getSpecifiedAttribute(String key, List<Report> reports)
	{
		List<ChartPoint> pointSet;
		for(Report report: report)
			switch(key[0])
			{
				case 'c': pointSet.add(ChartPoint(report.timestamp, report.co1)); break;
				case 't': pointSet.add(ChartPoint(report.timestamp, report.temperature)); break;
				case 'h': pointSet.add(ChartPoint(report.timestamp, report.humidity)); break;
				case 'n': pointSet.add(ChartPoint(report.timestamp, report.noise)); break;
				case 'u': pointSet.add(ChartPoint(report.timestamp, report.ultraviolet)); break;
			}
		return pointSet;
	}
}
