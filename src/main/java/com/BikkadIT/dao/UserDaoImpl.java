package com.BikkadIT.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BikkadIT.entity.User;

@Repository
public class UserDaoImpl implements UserDaoI{
	
	private static final Object id = null;
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveUserToDb(User user) {
		System.out.println("DAO LAYER METHOD");
		
		System.out.println(user);
		
		Session Session = sessionFactory.openSession();
		Session.beginTransaction();
		int save =(int) Session.save(user);
		Session.getTransaction().commit();
		return save;
	}

	@Override
	public List<User> getAllData() {
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from User");
		List<User> list=query.getResultList();
		return list;
		
	}

	@Override
	public List<User> getAllDataFromDB() {
   Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from User");
		List<User> list=query.getResultList();
		return list;
		
		
		
	}

	@Override
	public User getSingle(int uid) {
		
		Session session = sessionFactory.openSession();
		User user = session.get(User.class, uid);
				return user;
	}

	@Override
	public List<User> updatUser(User user) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		
		 Session session1 = sessionFactory.openSession();
			
			Query query = session.createQuery("from User");
			List<User> list=query.getResultList();
		
		return null;
	}

	

	@Override
	public List<User> deleteUserById(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = session.get(User.class, id);
		session.delete(user);
		session.getTransaction().commit();
		
		 Session session5 = sessionFactory.openSession();
			
			Query query = session5.createQuery("from User");
			List<User> list=query.getResultList();
			
			return list;

	
	}

	
}
