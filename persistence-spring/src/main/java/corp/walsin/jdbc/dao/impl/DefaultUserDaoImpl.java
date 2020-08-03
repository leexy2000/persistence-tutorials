package corp.walsin.jdbc.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import corp.walsin.jdbc.dao.UserDao;
import corp.walsin.jdbc.domain.User;
import corp.walsin.jdbc.mapper.UserMapper;

public abstract  class DefaultUserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void create(String unid, String name) {
		create(unid, name, null, null);
	}

	@Override
	public void create(String unid, String name, String gender, Date birthday) {
		String sql1 = "insert into user (unid,name, gender, birthday) values (?, ?,?,?)";
		jdbcTemplate.update(sql1, unid, name, gender, birthday);
	}

	@Override
	public void deleteByUnid(String unid) {
		String sql = "delete from user where unid = ?";
		jdbcTemplate.update(sql, unid);
	}

	@Override
	public User findByUnid(String unid) {
		String sql = "select * from user where unid = ?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), unid);
	}

	@Override
	public List<User> findByBirthdayLessthan(Date date) {
		String sql = "select * from user where birthday < ?";
		List<User> list = jdbcTemplate.query(sql, new UserMapper(), date);
		return list;
	}

}
