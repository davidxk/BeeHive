package beehive.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beehive.bean.Report;
import beehive.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class ReportDao {
	 String resource = "conf.xml";
     InputStream is = ReportDao.class.getClassLoader().getResourceAsStream(resource);
     SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
     
	public void save(Report report)
	{
		 	SqlSession session = MyBatisUtil.getSqlSession(true);
	        
	        String statement = "beehive.mapper.reportMapper.addReport";//映射sql的标识字符串
	        //insert
	        int retResult = session.insert(statement,report);
	        //手动提交事务
	        session.commit();
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        session.close();
	        //System.out.println(retResult);
	}
	
	public List<Report> getLatestReport(String phone, int n)
	{
	 		SqlSession session = MyBatisUtil.getSqlSession(true);
        
	 		String statement = "beehive.mapper.reportMapper.getLatestReport";//映射sql的标识字符串
	 		//insert
	 		Map<String, Object> param = new HashMap<String,Object>();
	 		param.put("phone", phone);
	 		param.put("number", n);
	 		List<Report> reportList = session.selectList(statement,param);
	 		//手动提交事务
	 		session.commit();
	 		//使用SqlSession执行完SQL之后需要关闭SqlSession
	 		session.close();
	 		//System.out.println(retResult);
			return reportList;
	}
	
	public List<Report> getTimedReport(String phone, String startTime, String endTime)
	{
	 		SqlSession session = MyBatisUtil.getSqlSession(true);
        
	 		String statement = "beehive.mapper.reportMapper.getTimedReport";//映射sql的标识字符串
	 		//insert
	 		Map<String, String> param = new HashMap<String, String>();
	 		param.put("phone", phone);
	 		param.put("startTime", startTime);
	 		param.put("endTime", endTime);
	 		List<Report> reportList = session.selectList(statement,param);
	 		//手动提交事务
	 		session.commit();
	 		//使用SqlSession执行完SQL之后需要关闭SqlSession
	 		session.close();
	 		//System.out.println(retResult);
			return reportList;
	}
	
	public List<Report> getAll(String phone)
	{
 		SqlSession session = MyBatisUtil.getSqlSession(true);
        
 		String statement = "beehive.mapper.reportMapper.getAll";//映射sql的标识字符串
 		//insert
     
 		List<Report> reportList = session.selectList(statement,phone);
 		//手动提交事务
 		session.commit();
 		//使用SqlSession执行完SQL之后需要关闭SqlSession
 		session.close();
 		//System.out.println(retResult);
		return reportList;
	}
	
	public Report getNewReport(String phone){
		SqlSession session = MyBatisUtil.getSqlSession(true);
 		String statement = "beehive.mapper.reportMapper.getNewReport";//映射sql的标识字符串
 		Report report = session.selectOne(phone);
 		//手动提交事务
 		session.commit();
 		//使用SqlSession执行完SQL之后需要关闭SqlSession
 		session.close();
 		//System.out.println(retResult);
		return report;
	}
	 
}