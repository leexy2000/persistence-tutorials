package corp.walsin.part01.service;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import corp.walsin.part01.domain.User;

public class UserService {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("user");

	public void create(String unid, String name) {
		this.create(unid, name, null, null);
	}

	public void create(String unid, String name, String gender, Date birthday) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = null;

		User user = new User();
		user.setUnid(unid);
		user.setName(name);
		user.setGender(gender);
		user.setBirthday(birthday);

		transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		transaction.commit();
		entityManager.close();
	}

	public User queryByUnid(String unid) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createQuery("from User u where u.unid = :unid");
		query.setParameter("unid", unid);
		Object obj = query.getSingleResult();
		return (User) obj;
	}

	public void deleteByUnid(String unid) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("delete User u where u.unid = :unid");
		query.setParameter("unid", unid);
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
	}
}
