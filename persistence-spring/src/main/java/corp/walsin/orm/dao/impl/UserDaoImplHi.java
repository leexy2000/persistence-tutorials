package corp.walsin.orm.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import corp.walsin.orm.dao.UserDao;
import corp.walsin.orm.domain.User1;

@Repository
public class UserDaoImplHi implements UserDao<User1> {

	private HibernateTemplate template;

	@Autowired
	public void setHibernateTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	@Override
	public void create(String unid, String name) {
		create(unid, name, null, null);
	}

	@Override
	@Transactional
	public void create(String unid, String name, String gender, Date birthday) {
		User1 user = new User1();
		user.setUnid(unid);
		user.setName(name);
		user.setGender(gender);
		user.setBirthday(birthday);
		template.persist(user);
	}

	@Override
	@Transactional
	public void deleteByUnid(String unid) {
		template.execute(session -> {
			Query query = session.createQuery("delete User1 u where u.unid = :unid");
			query.setParameter("unid", unid);
			query.executeUpdate();
			return null;		
		});
	}

	@Override
	@Transactional(readOnly=true)
	public User1 findByUnid(String unid) {
		return template.execute(session -> {
			Query query = session.createQuery("from User1 u where u.unid = :unid");
			query.setParameter("unid", unid);
			Object obj = query.getSingleResult();
			return (User1) obj;
		});
	}

	@Override
	@Transactional(readOnly=true)
	public List<User1> findByBirthdayLessthan(Date date) {
		return template.execute(session -> {
			Query query = session.createQuery("from User1 u where u.birthday <= :birthday");
			query.setParameter("birthday", date);
			@SuppressWarnings("unchecked")
			List<User1> list = query.getResultList();
			return list;
		});
	}

	@Override
	@Transactional(readOnly=true)
	public List<User1> findByAgeMorethan(int age) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(new Date());
		lastDate.add(Calendar.YEAR, -age);
		return findByBirthdayLessthan(lastDate.getTime());
	}

}
