package kr.or.dgit.mybatis_sample.service;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_sample.dao.StudentDao;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Log log = LogFactory.getLog(StudentService.class);
	private String namespace = "kr.or.dgit.mybatis_sample.dao.StudentDao.";
	
	public Student findStudentByNoWithAPI(Student student) {
		log.debug("findStudentByNoWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			return sqlSession.selectOne(namespace+"selectStudentByNoWithAPI", student);
		}
		
	}
	
	public List<Student> findStudentByAllWithAPI() {
		log.debug("findStudentByAllWithAPI()");
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			return sqlSession.selectList(namespace+"selectStudentByAllWithAPI");
		}
		
	}
	
	public int insertStudentWithAPI(Student student) {
		log.debug("insertStudentWithAPI()");
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			res = sqlSession.insert(namespace+"insertStudentWithAPI", student);
			sqlSession.commit();
		}
		return res;
	}
	
	public int updateStudentWithAPI(Student student) {
		log.debug("updateStudentWithAPI()");
		int res = -1;
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();){
			res = sqlSession.update(namespace+"updateStudentWithAPI", student);
			sqlSession.commit();
		}
		return res;
	}
}
