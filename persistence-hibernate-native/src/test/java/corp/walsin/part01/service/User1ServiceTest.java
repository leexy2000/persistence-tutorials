package corp.walsin.part01.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import corp.walsin.part01.domain.User1;

public class User1ServiceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//@Test
	public void testCreate() {
		User1Service service = new User1Service();
		service.create("un202001", "Jenny", "F", new Date());
	}

	@Test
	public void testQueryByUnid() {
		User1Service service = new User1Service();
		User1 user = service.queryByUnid("un202012");
		System.out.println(user.getName());
	}

	//@Test
	public void testDeleteByUnid() {
		User1Service service = new User1Service();
		service.deleteByUnid("un202001");
	}

}
