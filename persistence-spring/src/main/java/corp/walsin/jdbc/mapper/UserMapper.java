package corp.walsin.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import corp.walsin.jdbc.domain.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User entity = new User();
		entity.setUnid(rs.getString("unid"));
		entity.setName(rs.getString("name"));
		entity.setGender(rs.getString("gender"));
		entity.setBirthday(rs.getDate("birthday"));
		return entity;
	}

}
