package beehive.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

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
	        System.out.println(retResult);
	}
	
	
	
	
	
	
	 
}