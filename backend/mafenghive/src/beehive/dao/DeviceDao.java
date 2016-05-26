package beehive.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import beehive.bean.Device;
import beehive.bean.Switch;
import beehive.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DeviceDao {
	 String resource = "conf.xml";
     InputStream is = Device.class.getClassLoader().getResourceAsStream(resource);
     SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
     public boolean has(String phone){

    	 return true;	     
 }
 
 public void save(Device device){
       
 }
 
 public void fix(Device device){
       
 }
 
 public Switch getDeviceInfo(String phone){
	 Switch switchinfo=null;
     return switchinfo;  
 }
	 
}
