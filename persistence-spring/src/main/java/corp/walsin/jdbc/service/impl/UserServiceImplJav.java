package corp.walsin.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import corp.walsin.jdbc.dao.UserDao;

@Service("userService")
public class UserServiceImplJav extends DefaultUserServiceImpl {

	@Autowired
	public void setUserDao(UserDao dao) {
		super.setUserDao(dao);
	}

}
