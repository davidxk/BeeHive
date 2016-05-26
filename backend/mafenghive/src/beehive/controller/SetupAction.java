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


public class SetupAction extends HttpServlet {

	private DeviceDao devicedao = new DeviceDao();
	public SetupAction() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	
	}
    
   
    private void setDevice(String phone, HashMap map){
    	
    }
    
    
    private void resetDevice(String phone,HashMap map){
    	
    }
    
    private Device getDeviceInfo(String phone){
    	Device device = null;
    	return device;
    }
    
   private void setSwitch(String phone, HashMap map){
    	
    }
   private Switch getSwitch(String phone, HashMap map){
   		Switch switchInfo = null;
	   return switchInfo;
   }
    
}
