package com.batis.mybatisdao.tests.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import com.batis.mybatisdao.tests.dao.BaseBatisDao;
import com.batis.mybatisdao.tests.model.Student;
import com.batis.mybatisdao.JdbcBaseBatisDAO;

public class StudentDao extends JdbcBaseBatisDAO<Student, Integer>{
	public StudentDao(SqlSessionFactory containerSessionFactory) {
		super(containerSessionFactory);
	}
}
