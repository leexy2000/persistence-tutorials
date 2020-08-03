package corp.walsin.part01.service;

import java.util.Date;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import corp.walsin.util.HibernateHelper;
import corp.walsin.part01.domain.User2;

public class User2Service {
	static SessionFactory sessionFactory = HibernateHelper.buildSessionFactory();

	public void create(String unid, String name) {
		this.create(unid, name, null, null);
	}

	public void create(String unid, String name, String gender, Date birthday) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		User2 user = new User2();
		user.setUnid(unid);
		user.setName(name);
		user.setGender(gender);
		user.setBirthday(birthday);

		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
	}

	public User2 queryByUnid(String unid) {
		Session session = sessionFactory.openSession();
		String sql = "from User2 u  where u.unid = :unid";
		Query query = session.createQuery(sql);
		query.setParameter("unid", unid);
		Object obj = query.getSingleResult();
		session.close();
		return (User2) obj;
	}

	public void deleteByUnid(String unid) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String sql = "delete  User2 u  where u.unid = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, "un202001");
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}

	}

}
