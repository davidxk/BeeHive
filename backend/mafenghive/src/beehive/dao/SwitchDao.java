package beehive.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beehive.bean.Report;
import beehive.bean.Switch;
import beehive.bean.User;
import beehive.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SwitchDao {
	 String resource = "conf.xml";
     InputStream is = Switch.class.getClassLoader().getResourceAsStream(resource);
     SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
     
	 
	 public Switch getStatus(int id){
		 
		 SqlSession session = MyBatisUtil.getSqlSession(true);
	        
	 	String statement = "beehive.mapper.switchtMapper.getStatus";//映射sql的标识字符串
	 		//insert
	 	Switch status = null ;
	 			status = session.selectOne(statement,id);
	 		//手动提交事务
	 		session.commit();
	 		//使用SqlSession执行完SQL之后需要关闭SqlSession
	 		session.close();
	 		//System.out.println(retResult);
			return status;    
	 }
	 
	 public void updateStatus(int isOn){
		 SqlSession session = MyBatisUtil.getSqlSession(true);
	        
		 	String statement = "beehive.mapper.switchtMapper.updateStatus";//映射sql的标识字符串
		 		//insert
		 	int status = session.update(statement,isOn);
		 		//手动提交事务
		 		session.commit();
		 		//使用SqlSession执行完SQL之后需要关闭SqlSession
		 		session.close();
	 }
	 

	 
}