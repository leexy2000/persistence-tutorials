package corp.walsin.part01.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import corp.walsin.part01.domain.User2;

public class User2ServiceTest {

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
			User2Service service = new User2Service();
			service.create("un202001", "Jenny", "F", new Date());
		}

		@Test
		public void testQueryByUnid() {
			User2Service service = new User2Service();
			User2 user = service.queryByUnid("un202012");
			System.out.println(user.getName());
		}

		//@Test
		public void testDeleteByUnid() {
			User2Service service = new User2Service();
			service.deleteByUnid("un202001");
		}

}
