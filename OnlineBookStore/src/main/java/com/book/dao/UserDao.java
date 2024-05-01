package com.book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EntityTransaction entityTransaction;
	
	public  Integer uid;

	public void save(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}
	
	public void update(User user) {
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
	}
	
	public void delete(User user) {
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
		}
	}
	
	public User getUser(int id) {
		return entityManager.find(User.class, id);
	}
	
	public List<User> getUsers() {
		Query query=entityManager.createQuery("select e from User e");
		return query.getResultList();
	}
	public boolean validationUser(User user) {
		String email=user.getEmail();
		String password=user.getPassword();
	    Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2");

		query.setParameter(1, email);
		query.setParameter(2, password);
		  try {
		        User result = (User) query.getSingleResult();
		        uid=result.getId();
		        return result != null; 
		    } catch (NoResultException e) {
		        return false;
		    }
	}
	
	public boolean emailv(User user) {
		String email=user.getEmail();
	    Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = ?1 ");
		query.setParameter(1, email);
		  try {
		        User result = (User) query.getSingleResult();
		        return result != null; 
		    } catch (NoResultException e) {
		        return false;
		    }
	}
	
}
