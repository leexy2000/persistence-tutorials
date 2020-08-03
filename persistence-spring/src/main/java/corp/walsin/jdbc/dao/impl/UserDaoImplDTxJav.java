package corp.walsin.jdbc.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import corp.walsin.jdbc.domain.User;

@Repository("userDao")
public class UserDaoImplDTxJav extends DefaultUserDaoImpl {

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		super.setJdbcTemplate(jdbcTemplate);
	}

	@Override
	@Transactional
	public void create(String unid, String name) {
		super.create(unid, name);
	}

	@Override
	@Transactional
	public void create(String unid, String name, String gender, Date birthday) {
		super.create(unid, name, gender, birthday);
	}

	@Override
	@Transactional
	public void deleteByUnid(String unid) {
		super.deleteByUnid(unid);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUnid(String unid) {
		return super.findByUnid(unid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findByBirthdayLessthan(Date date) {
		return super.findByBirthdayLessthan(date);
	}

}
