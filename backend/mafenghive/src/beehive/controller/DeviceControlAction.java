package beehive.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beehive.dao.DeviceDao;
import beehive.bean.Device;
import beehive.dao.SwitchDao;
import beehive.bean.Switch;
import beehive.dao.UserDao;
import beehive.bean.User;
public class DeviceControlAction extends HttpServlet {

	private DeviceDao devicedao = new DeviceDao();
	public DeviceControlAction() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	
	}
    
   
    private Switch getSwitchStatus(String phone, HashMap map){
   		Switch switchInfo = null;
	   return switchInfo;
   }
    
    
    private void setAuto(String phone, Boolean onoroff ){
    	
    }
    
    private Boolean getAuto(String phone){
    	
    	return true;
    }
    
    private void turnOn(String phone, int switchId){
    	
    }
    
    private void turnOff(String phone, int switchId){
    	
    }
    
}
