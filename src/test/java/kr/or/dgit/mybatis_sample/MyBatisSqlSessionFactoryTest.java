package kr.or.dgit.mybatis_sample;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_sample.util.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest {
	private static SqlSessionFactory factory;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		factory = null;
	}
	
	@Test
	public void test() {
		Assert.assertNotNull(factory);
	}
}
