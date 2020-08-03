package corp.walsin.orm.dao;

import java.util.Date;
import java.util.List;

public interface UserDao<T> {
	void create(String unid, String name);

	void create(String unid, String name, String gender, Date birthday);

	void deleteByUnid(String unid);

	T findByUnid(String unid);

	List<T> findByBirthdayLessthan(Date date);

	List<T> findByAgeMorethan(int age);

}
