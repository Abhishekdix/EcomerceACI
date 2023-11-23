package com.jtspringproject.JtSpringProject.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.categoryService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;
import com.mysql.cj.protocol.Resultset;

import net.bytebuddy.asm.Advice.This;
import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private userService userService;
	@Autowired
	private categoryService categoryService;

	@Autowired
	private productService productService;

	int adminlogcheck = 0;

	String usernameforclass = "";

	@RequestMapping(value = {"/", "/logout"})
	public String returnIndex() {
		adminlogcheck = 0;
		usernameforclass = "";
		return "userLogin";
	}

	@RequestMapping(value = "adminRegister", method = RequestMethod.POST)
	public String newUseRegister(@ModelAttribute User user) {


		user.setRole("ROLE_ADMIN");

		this.userService.addUser(user);

		return "adminlogin";
	}

	@RequestMapping(value = "verify", method = RequestMethod.POST)
	public String search(@RequestParam("password") String password) {

		if (password.equals("admin@123")) {
			return "adminRegister";
		} else {
			return "adminVerify";
		}
	}


	@GetMapping("adminVerify")
	public String verify() {
		return "adminVerify";
	}


	@GetMapping("/index")
	public String index(Model model) {
		if (usernameforclass.equalsIgnoreCase(""))
			return "userLogin";
		else {
			model.addAttribute("username", usernameforclass);
			return "index";
		}

	}


	@GetMapping("login")
	public String adminlogin() {

		return "adminlogin";
	}
}
	
	
	



