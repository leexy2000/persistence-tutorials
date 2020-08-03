package corp.walsin.jdbc.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import corp.walsin.jdbc.dao.UserDao;
import corp.walsin.jdbc.domain.User;
import corp.walsin.jdbc.mapper.UserMapper;

@Repository
public class UserDaoImplPPTxMgr implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Override
	public void create(String unid, String name) {
		create(unid, name, null, null);
	}

	@Override
	public void create(String unid, String name, String gender, Date birthday) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			String sql1 = "insert into user (unid,name, gender, birthday) values (?, ?,?,?)";
			jdbcTemplate.update(sql1, unid, name, gender, birthday);
			transactionManager.commit(status);
		} catch (DataAccessException e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public void deleteByUnid(String unid) {
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			String sql = "delete from user where unid = ?";
			jdbcTemplate.update(sql, unid);
			transactionManager.commit(status);
		} catch (DataAccessException e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public User findByUnid(String unid) {
		String sql = "select * from user where unid = ?";
		return jdbcTemplate.queryForObject(sql, new UserMapper(), unid);
	}

	@Override
	public List<User> findByBirthdayLessthan(Date date) {
		String sql = "select * from user where birthday <= ?";
		List<User> list = jdbcTemplate.query(sql, new UserMapper(), date);
		return list;
	}

}
