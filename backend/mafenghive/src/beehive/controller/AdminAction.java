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


public class AdminAction extends HttpServlet {


	
	
	
	
	
	
	public AdminAction() {
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
    
    
    private List<User> getUser(HashMap map){
    	List<User> users = null;
    	return users;
    }
    
    private void deleteUser(String phone){
    	
    }
    private void fixUser(String phone){
    	
    }
   
    private void addUser(HashMap map){
    	
    }
   
}
