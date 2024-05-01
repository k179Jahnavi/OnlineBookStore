package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.dao.BookDao;
import com.book.dao.UserDao;
import com.book.model.User;

@Controller
public class UserController {

		@Autowired
		private UserDao dao;
		@Autowired
		private BookDao bookDao;
		
		@RequestMapping("/addusers")
		public ModelAndView userLogin() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("user",new User());
			mv.setViewName("userform");
			return mv;
		}
		
		@RequestMapping("/saveuser")
		public ModelAndView save(@ModelAttribute User user) {
			ModelAndView mv=new ModelAndView();
			if(dao.emailv(user)) {
				mv.addObject("smsg"," This email is alredy is there");
				mv.setViewName("userform");
			}else {
				dao.save(user);
				mv.setViewName("redirect:/admind");
			}
			return mv;
		}
		
		@RequestMapping("/userlogin")
		public ModelAndView user() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("user",new User());
			mv.setViewName("userlogin");
			return mv;
		}
		
		@RequestMapping("/loginuser")
		public ModelAndView UserLogin(@ModelAttribute User user) {
			ModelAndView mv=new ModelAndView();
			if(dao.validationUser(user)) {
				mv.setViewName("userhome");
			}else {
				mv.addObject("msg","Invalid user name or password");
				mv.setViewName("userlogin");
			}
			return mv;
		}
	
		@RequestMapping("/up")
		public ModelAndView updateUser(@RequestParam Integer id) {
			ModelAndView mv=new ModelAndView();
			mv.addObject("user",dao.getUser(id));
			mv.setViewName("userform");
			return mv;
		}
		
		@RequestMapping("/up/update")
		public ModelAndView update(@ModelAttribute User user) {
			dao.update(user);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("redirect:/admind");
			return mv;
		}
		@RequestMapping("/delete")
		public ModelAndView deleteuser(@RequestParam Integer id) {
			ModelAndView mv=new ModelAndView();
			dao.delete(dao.getUser(id));
			mv.setViewName("redirect:/admind");
			return mv;
		}
		
		@RequestMapping("/userd")
		public ModelAndView userd() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("user",dao.getUser(dao.uid));
			mv.setViewName("singleuserdetails");
			return mv;
		}
		
		@RequestMapping("/displaybooksuser")
		public ModelAndView display() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("book",bookDao.getBooks());
			mv.setViewName("userbooks");
			return mv;
		}
		
		
		@RequestMapping("/userh")
		public ModelAndView home() {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("userhome");
			return mv;
		}
		
}