package kr.or.dgit.mybatis_sample;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;

import kr.or.dgit.mybatis_sample.dto.PhoneNumber;
import kr.or.dgit.mybatis_sample.dto.Student;
import kr.or.dgit.mybatis_sample.service.StudentService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		service = new StudentService();
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		service = null;
	}
	
	@Test
	public void test1FindStudentByNo() {
		/*Student student = new Student();
		student.setStudId(1);
		
		Student selectStudent = studentService.findStudentByNo(student);
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());*/
		
		Student student = service.findStudentByNo(new Student(1));
		Assert.assertNotNull(student);
	}
	
	@Test
	public void test2FindStudentByAll() {
		List<Student> listStd = service.findStudentByAll();
		Assert.assertNotNull(listStd);
		for(Student std : listStd) {
			System.out.println(std);
		}
	}
	
	
/*	@Test
	public void test5InsertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		
		Student student = new Student(3, "홍길동3", "lee@test.co.kr", new PhoneNumber("010-1234-1234"), newDate.getTime());
		int res = service.insertStudent(student);
		Assert.assertEquals(1, res);
	}*/
	
	@Test
	public void testUpdateStudent() {
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("timothyUpdate@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int result = service.updateStudent(student);
		Assert.assertSame(1, result);
	}
}
