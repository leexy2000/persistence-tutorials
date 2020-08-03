package corp.walsin.jdbc.dao.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import corp.walsin.jdbc.dao.UserDao;
import corp.walsin.jdbc.domain.User;
import corp.walsin.jdbc.mapper.UserMapper;

@Repository
public class UserDaoImplPTxTmpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Override
	public void create(String unid, String name) {
		create(unid, name, null, null);
	}

	@Override
	public void create(String unid, String name, String gender, Date birthday) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					String sql1 = "insert into user (unid,name, gender, birthday) values (?, ?,?,?)";
					jdbcTemplate.update(sql1, unid, name, gender, birthday);
				} catch (DataAccessException e) {
					e.printStackTrace();
					status.setRollbackOnly();
				}
			}
		});
	}

	@Override
	public void deleteByUnid(String unid) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					String sql = "delete from user where unid = ?";
					jdbcTemplate.update(sql, unid);
				} catch (DataAccessException e) {
					status.setRollbackOnly();
				}
			}
		});
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
