package corp.walsin.jdbc.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import corp.walsin.jdbc.dao.UserDao;
import corp.walsin.jdbc.domain.User;
import corp.walsin.jdbc.service.UserService;

public abstract class DefaultUserServiceImpl implements UserService {

	private UserDao dao;

	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(String unid, String name) {
		dao.create(unid, name);
	}

	@Override
	public void create(String unid, String name, String gender, String birthday) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dao.create(unid, name, gender, formatter.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByUnid(String unid) {
		dao.deleteByUnid(unid);
	}

	@Override
	public User findByUnid(String unid) {
		return dao.findByUnid(unid);
	}

	@Override
	public List<User> findByBirthdayLessthan(Date date) {
		return dao.findByBirthdayLessthan(date);
	}

	@Override
	public List<User> findByAgeMorethan(int age) {
		Calendar lastDate = Calendar.getInstance();
		LocalDate localDate = LocalDate.now();
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		Date date = Date.from(instant);
		lastDate.setTime(date);
		lastDate.add(Calendar.YEAR, -age);
		return dao.findByBirthdayLessthan(lastDate.getTime());
	}

}
