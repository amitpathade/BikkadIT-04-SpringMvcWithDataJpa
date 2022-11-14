package com.BikkadIT.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.BikkadIT.entity.User;
import com.BikkadIT.service.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl UserServiceI;
	
	@GetMapping("/welcome")
	public String loadForm() {
		
		return "registration";
		
	}
	@GetMapping("/login")
	public String prelogin() {
		return "login";
		
		
		
	}
	@PostMapping("/reg")
	public String userRegistration(User user, Model model) {
		System.out.println("control layer method");
		
		int id = UserServiceI.saveUser(user);
		System.out.println(user);
		model.addAttribute("ID", id);
		
		return "userSucess";
		
	}
	@GetMapping("/log")
	public String loginCheck(User user) {
		System.out.println(user);
		Boolean loginCheckServiceLauer = UserServiceI.loginCheckServiceLauer(user);
		if(loginCheckServiceLauer) {
		return "loginSucess";
		}else
		return "loginfail";
		
	}
	@GetMapping("/getAllData")
	public String getAllData(Model model) {
		List<User> all = UserServiceI.getAll();
		
		model.addAttribute("list", all);
		
		return "getAllData" ;
		
		
	}
	@GetMapping("/getSingleUser/{uid}")
	public String getSingleUser(@PathVariable int uid,Model model) {
		User singelUser = UserServiceI.getSingelUser(uid);
		System.out.println(singelUser);
		model.addAttribute( "USER",singelUser);
		return "getSingleUser";
		
	}
	@GetMapping("/update")
	public String preUpdate() {
		return "update";
		
	}
	@PostMapping("/updateUser")
	public String updateUser(User user , Model model) {
		System.out.println(user);
		List<User> updateUser = UserServiceI.updateUser(user);
		System.out.println(updateUser);
		model.addAttribute("list", updateUser);
		
	
		return "updatedList";
		
		
	}
	@GetMapping("/deletebyId/{id}")
	public String deleteUser(@PathVariable Integer id, Model model) {
		
		List<User> list = UserServiceI.deleteUser(id);
		model.addAttribute("list", list);
		return "updatedList";
		
	}

}
