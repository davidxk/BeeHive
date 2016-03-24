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
	         * 映射sql的标识字符串，
	         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
	         * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
	         */
	        String statement = "beehive.mapper.userMapper.addUser";//映射sql的标识字符串
	        //执行插入操作
	        int retResult = sqlSession.insert(statement,user);
	        //手动提交事务
	        sqlSession.commit();
	        //使用SqlSession执行完SQL之后需要关闭SqlSession
	        sqlSession.close();
	        System.out.println(retResult);
	 }
	 
	 public User getUser(int phone){
		 String statement = "beehive.mapper.userMapper.getUser";
	     User user = session.selectOne(statement, phone);
	     return user;
	     
	 }

	 
	 
}
