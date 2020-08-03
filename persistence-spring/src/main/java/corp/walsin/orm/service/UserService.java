package corp.walsin.orm.service;

import java.util.Date;
import java.util.List;
import corp.walsin.jdbc.domain.User;

public interface UserService {
	
	void create(String unid, String name);

	void create(String unid, String name, String gender, String birthday);

	void deleteByUnid(String unid);

	User findByUnid(String unid);

	List<User> findByBirthdayLessthan(Date date);

	List<User> findByAgeMorethan(int age);
}
