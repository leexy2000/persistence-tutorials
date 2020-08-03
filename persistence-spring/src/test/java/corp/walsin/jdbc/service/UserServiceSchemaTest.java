package corp.walsin.jdbc.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import corp.walsin.jdbc.domain.User;

public class UserServiceSchemaTest {

	AbstractApplicationContext context = null;
	UserService service = null;
	static SimpleDateFormat formatter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		formatter = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("config/DTxMgrBeansSchema.xml");
		service = (UserService) context.getBean("userService");
	}

	@After
	public void tearDown() throws Exception {
		context.close();
	}

	@Test
	public void testCreate() {
		System.out.println("------Records creation--------");
		service.create("uu202001", "Zara", "F", "1971-11-11");
		service.create("uu202002", "KiKi", "F", "1982-01-10");
		service.create("uu202003", "Jenny", "M", "1988-07-30");
		service.create("uu202004", "Tom");
		service.create("uu202005", "Carl Max", "F", "1990-10-11");
	}

	//@Test
	public void testDelete() {
		System.out.println("------Records delete by Unid--------");
		service.deleteByUnid("uu202001");
		service.deleteByUnid("uu202002");
		service.deleteByUnid("uu202003");
		service.deleteByUnid("uu202004");
		service.deleteByUnid("uu202005");
	}

	// @Test
	public void testFindByUnid() {
		System.out.println("------Records find by Unid--------");
		User user = service.findByUnid("uu202003");
		System.out.println(user.getName() + " -- " + user.getAge());
	}

	//@Test
	public void testFindByAgeMorethan() {
		List<User> list = service.findByAgeMorethan(32);
		for (User user : list) {
			System.out.println(user.getName() + " -- " + user.getAge());
		}
	}

}