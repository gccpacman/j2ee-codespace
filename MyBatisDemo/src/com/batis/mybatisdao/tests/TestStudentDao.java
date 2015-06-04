package com.batis.mybatisdao.tests;

import java.io.Reader;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import com.batis.mybatisdao.tests.dao.StudentDao;
import com.batis.mybatisdao.tests.model.Student;

public class TestStudentDao {

	private static Logger log = Logger.getLogger(TestStudentDao.class);
	private static SqlSessionFactory sf;
	private static StudentDao studentDao;
	
	
	@BeforeClass
	public static void setUp() throws Exception {
		log.info("Mybatis setup is in process...");
		String resource = "mybatisConfig.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		sf = new SqlSessionFactoryBuilder().build(reader, "mobisoft");
		studentDao = new StudentDao(sf);
		
		log.info("Connection Established Successfully.");
		
	}
	
	@Test
	public static void getAllStudent(){
		ArrayList<Student> list = studentDao.getAllStudentList();
		log.info("Student List");
		printStudentList(list);
	}
	
	
	@Test
	public static void createStudent(){
		Student student = new Student();
		student.setStudentName("Mayur");
		student.setMarks(82);
		Integer rollNo = studentDao.insertStudent(student);
		log.info("insert Student Details:" + rollNo);
	}

	
	public static void updateStudent(){
		Student student  =  new Student();
		student.setRollNo(1);
		student.setStudentName("John P");
		student.setMarks(81);
		Integer result =  studentDao.updateStudentDetails(student);
		log.info("update Student Details:" + result);
	}
	
	public static void deleteStudent(){
		Integer rollNo =  studentDao.deleteStudentFromDB(3);
		log.info("delete Student's rollNo:" + rollNo);
	}
	
	
	private static void printStudentList(ArrayList<?> studentList){
		for(int i=0;i<studentList.size();i++){
			log.info(studentList.get(i).toString());
		}
	}
	
	
	
	
	
	public static void main(String[] args){
		try{
			setUp();
			
			getAllStudent();
			createStudent();
			getAllStudent();
			updateStudent();
			getAllStudent();
			deleteStudent();
			getAllStudent();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
