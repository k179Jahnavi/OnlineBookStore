package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.dao.BookDao;
import com.book.dao.UserDao;
import com.book.model.Book;

@RestController
public class BookController {

	@Autowired
	BookDao bookDao;
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/addbooks")
	public ModelAndView userLogin() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("book",new Book());
		mv.setViewName("addbooks");
		return mv;
	}
	
	@RequestMapping("/addbook")
	public ModelAndView savebook(@ModelAttribute Book book) {
		bookDao.save(book);
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",userDao.getUsers());
		mv.setViewName("adminhome");
		return mv;
	}
	
	@RequestMapping("/displaybooks")
	public ModelAndView display() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("book",bookDao.getBooks());
		mv.setViewName("displaybooks");
		return mv;
	}
	
	@RequestMapping("/updatebook")
	public ModelAndView updtaebook(@RequestParam Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("view",bookDao.getBook(id));
		mv.setViewName("addbooks");
		return mv;
	}
	
	@RequestMapping("/updateb")
	public ModelAndView update(@ModelAttribute Book book) {
		bookDao.update(book);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admind");
		return mv;
	}
	
	@RequestMapping("/deletebook")
	public ModelAndView delete(@RequestParam Integer id) {
		bookDao.delete(bookDao.getBook(id));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admind");
		return mv;
	}
	
}
