package com.batis.mybatisdao.tests.dao;

import java.util.ArrayList;

import org.apache.ibatis.exceptions.PersistenceException;


public interface BaseBatisDao<Obj, PK> {

	public ArrayList<Obj> getAllStudentList() throws PersistenceException;
	public int insertStudent(Obj student) throws PersistenceException;
	int updateStudentDetails(Obj student) throws PersistenceException;
	int deleteStudentFromDB(PK rollNo) throws PersistenceException;
	
}
