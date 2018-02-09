package kr.or.dgit.mybatis_sample;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Assert;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		studentService = new StudentService();
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		studentService = null;
	}
	
	@Test
	public void test1FindStudentByNo() {
		Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = studentService.findStudentByNo(student);
		//studentService.findStudentByNo(new Student(1));
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
}
