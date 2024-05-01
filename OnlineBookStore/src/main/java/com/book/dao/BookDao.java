package com.book.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.model.Book;


@Repository
public class BookDao {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private EntityTransaction entityTransaction;
	
	public void save(Book book) {
		entityTransaction.begin();
		entityManager.persist(book);
		entityTransaction.commit();
	}
	
	public void update(Book book) {
		entityTransaction.begin();
		entityManager.merge(book);
		entityTransaction.commit();
	}
	
	public void delete(Book book) {
		if(book!=null) {
			entityTransaction.begin();
			entityManager.remove(book);
			entityTransaction.commit();
		}
	}
	
	public Book getBook(int id) {
		return entityManager.find(Book.class, id);
	}
	
	public List<Book> getBooks() {
		Query query=entityManager.createQuery("select e from Book e");
		return query.getResultList();
	}
	
	
}
