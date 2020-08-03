package corp.walsin.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import corp.walsin.jdbc.dao.UserDao;

public class UserServiceImplTxTmpl extends DefaultUserServiceImpl {

	@Autowired
	public void setUserDao(UserDao dao) {
		super.setUserDao(dao);
	}
	
}
