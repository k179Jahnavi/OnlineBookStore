package com.book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.model.Admin;


@Repository
public class AdminDao {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EntityTransaction entityTransaction;
	
	public void save(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
	
	public void update(Admin admin) {
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
	}
	
	public void delete(Admin admin) {
		if(admin!=null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
		}
	}
	
	public Admin getAdmin(int id) {
		return entityManager.find(Admin.class, id);
	}
	
	public List<Admin> getAdmins() {
		Query query=entityManager.createQuery("select e from Admin e");
		return query.getResultList();
	}
	
	public boolean validationAdmin(Admin Admin) {
		String email=Admin.getEmail();
		String password=Admin.getPassword();
	    Query query = entityManager.createQuery("SELECT u FROM Admin u WHERE u.email = ?1 AND u.password = ?2");

		query.setParameter(1, email);
		query.setParameter(2, password);
		  try {
		        Admin result = (Admin) query.getSingleResult();
		        return result != null; 
		    } catch (NoResultException e) {
		        return false;
		    }
	}
	
}
