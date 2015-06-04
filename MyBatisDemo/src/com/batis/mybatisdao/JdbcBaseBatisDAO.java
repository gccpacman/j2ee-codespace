package com.batis.mybatisdao;

import java.util.ArrayList;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

public class JdbcBaseBatisDAO <Obj, PK>{

	private static Logger log = Logger.getLogger(JdbcBaseBatisDAO.class);
	
	private SqlSessionFactory sqlSessionFactory;
	
	private static final String NAMESPACE="mobisoft";
	
	public static final String PREFIX_SELECT_QUERY="get";
	public static final String PREFIX_INSERT_QUERY="create";
	public static final String PREFIX_UPDATE_QUERY="update";
	public static final String PREFIX_DELETE_QUERY="delete";
	
	public JdbcBaseBatisDAO(SqlSessionFactory sf) {
		
		this.sqlSessionFactory = sf;
		if (sf == null)
			log.error("Error: sessionFactory loading failed.");
	
	}
	
	public ArrayList<Obj> getAllStudentList() throws PersistenceException{
		
		SqlSession session = sqlSessionFactory.openSession();
		
		ArrayList<Obj> studentList = null;
		try{
			String query = NAMESPACE+"."+PREFIX_SELECT_QUERY+"AllStudent";
			studentList = (ArrayList<Obj>) session.selectList(query);
		}finally{
			session.close();
		}

		return studentList;
	}
	
	public int insertStudent(Obj student) throws PersistenceException{
		
		SqlSession session = sqlSessionFactory.openSession();
		Integer rollNo = null;
		try{
			String query = NAMESPACE+"."+PREFIX_INSERT_QUERY+"Student";
			rollNo = (Integer) session.insert(query, student);
			session.commit();
		}finally{
			session.close();
		}
		
		return rollNo;
	}
	
	public int updateStudentDetails(Obj student) throws PersistenceException{
		SqlSession session = sqlSessionFactory.openSession();
		Integer rollNo = null;
		try{
			String query = NAMESPACE + "." + PREFIX_UPDATE_QUERY + "Student";
			rollNo = session.update(query, student);
			session.commit();
		}finally{
			session.close();
		}
		return rollNo;
	}
	
	public int deleteStudentFromDB(PK rollNo) throws PersistenceException{
		SqlSession session = sqlSessionFactory.openSession();
		Integer status=null;
		try{
			String query = NAMESPACE + '.' + PREFIX_DELETE_QUERY+"Student";
			status=session.delete(query, rollNo);
			session.commit();
		}finally{
			session.close();
		}
		return status;
	}
	
}
