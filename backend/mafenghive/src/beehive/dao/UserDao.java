package beehive.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import beehive.bean.User;
import beehive.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.Test1;


public class UserDao {
	 String resource = "conf.xml";
     InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
     SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
     SqlSession session = sessionFactory.openSession();
     
	 public boolean has(int phone){
	     String statement = "beehive.mapper.userMapper.getUser";
	     User user = session.selectOne(statement, phone);
	     if(user == null)
	    	 return false;
	     else
	    	 return true;	     
	 }
	 
	 public void save(User user){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.userMapper��userMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * addUser��insert��ǩ��id����ֵ��ͨ��insert��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "beehive.mapper.userMapper.addUser";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в������
	        int retResult = sqlSession.insert(statement,user);
	        //�ֶ��ύ����
	        sqlSession.commit();
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	 }
	 
	 public User getUser(int phone){
		 String statement = "beehive.mapper.userMapper.getUser";
	     User user = session.selectOne(statement, phone);
	     return user;
	     
	 }

	 
	 
}
