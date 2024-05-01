package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.book.dao.AdminDao;
import com.book.dao.BookDao;
import com.book.dao.UserDao;
import com.book.model.Admin;

@RestController
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookDao dao;
	
	@RequestMapping({"/","/backl"})
	public ModelAndView load() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("admin",new Admin());
		mv.setViewName("adminaccount");
		return mv;
	}
	
	@RequestMapping({"/admind","/backhome"})
	public ModelAndView dadmin() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",userDao.getUsers());
		mv.addObject("book",dao.getBooks());
		mv.setViewName("adminhome");
		return mv;
	}
	
	@RequestMapping("/adminacc")
	public ModelAndView adminSignin(@ModelAttribute Admin admin) {
		adminDao.save(admin);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect:/admind");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView adminloginpage() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("admin",new Admin());
		mv.setViewName("adminlogin");
		return mv;
	}
	
	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(@ModelAttribute Admin admin) {
		ModelAndView mv=new ModelAndView();
		if(adminDao.validationAdmin(admin)) {
			mv.setViewName("redirect:/admind");
		}else {
			mv.addObject("msg","Invalid user name or password");
			mv.setViewName("adminlogin");
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	
	
}
