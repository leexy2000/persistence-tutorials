package corp.walsin.jdbc.dao;

import java.util.Date;
import java.util.List;
import corp.walsin.jdbc.domain.User;

public interface UserDao {
	void create(String unid, String name);

	void create(String unid, String name, String gender, Date birthday);

	void deleteByUnid(String unid);

	User findByUnid(String unid);

	List<User> findByBirthdayLessthan(Date date);

}
