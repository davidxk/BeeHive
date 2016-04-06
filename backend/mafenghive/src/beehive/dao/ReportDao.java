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

import test.Test1;


public class ReportDao {
	 String resource = "conf.xml";
     InputStream is = ReportDao.class.getClassLoader().getResourceAsStream(resource);
     SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
     SqlSession session = sessionFactory.openSession();
     
	public void save(Report report)
	{
		 SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	        
	        String statement = "beehive.mapper.reportMapper.addReport";//ӳ��sql�ı�ʶ�ַ���
	        //insert
	        int retResult = sqlSession.insert(statement,report);
	        //�ֶ��ύ����
	        sqlSession.commit();
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	}
	
	
	
	
	
	
	 
}