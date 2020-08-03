package corp.walsin.part01.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import corp.walsin.part01.domain.User;

public class UserServiceTest {

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

	// @Test
	public void testCreation() {
		UserService service = new UserService();
		service.create("un202010", "Jenny", "F", new Date());
		service.create("un202011", "Tomson Max");
	}

	@Test
	public void testQueryByUnid() {
		UserService service = new UserService();
		User user = service.queryByUnid("un202012");
		System.out.println(user.getName());
	}

	//@Test
	public void testDeleteByUnid() {
		UserService service = new UserService();
		service.deleteByUnid("un202010");

	}

}
