package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dao.StudentDaoImpl;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	public Student findStudentByNo(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByNo(student);
		}
		
	}
	
	public List<Student> findStudentByAll() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByAll();
		}
		
	}
	
	public Student findStudentByNoWithAPI(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByNoWithAPI(student);
		}
		
	}
	
	public List<Student> findStudentByAllWithAPI() {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			return studentDao.selectStudentByAllWithAPI();
		}
		
	}
	
	public int insertStudent(Student student) {
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			res = studentDao.insertStudent(student);
			sqlSession.commit();
		}
		return res;
		
	}
	
	public int insertStudentWithAPI(Student student) {
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			StudentDao studentDao = new StudentDaoImpl(sqlSession);
			res = studentDao.insertStudentWithAPI(student);
			sqlSession.commit();
		}
		return res;
		
	}
}
