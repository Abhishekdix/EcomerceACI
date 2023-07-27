package com.jtspringproject.JtSpringProject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;



@Controller
public class UserController{
	
	@Autowired
	private userService userService;

	@Autowired
	private productService productService;
	
	


	@GetMapping("/register")
	public String registerUser()
	{
		return "register";
	}

	@GetMapping("/buy")
	public String buy()
	{
		return "buy";
	}
	
	@GetMapping("/admin")
	public String adminLogin()
	{
		return "";
	}
	
	int adminlogcheck=0;
	

	
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search( @RequestParam("search") String search,Model model,HttpServletResponse res) {
		ModelAndView mView  = new ModelAndView("index");
		System.out.println("Search element"+search);
		
		List<Product> products = this.productService.getProductSearch(search);
		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;
	}
	
	
	@RequestMapping(value = "RangeSort", method = RequestMethod.POST)
	public ModelAndView search( @RequestParam("lowPrice") String lowPrice,@RequestParam("highPrice") String highPrice,Model model,HttpServletResponse res) {
		ModelAndView mView  = new ModelAndView("index");
		
		
		int highP=Integer.parseUnsignedInt(highPrice);
		int lowP=Integer.parseUnsignedInt(lowPrice);
		
		System.out.println(lowPrice+" "+highPrice);
		
		List<Product> products = this.productService.getProducts();
		List<Product> sortedProducts=new ArrayList<>();
		
		for (Product product : products)
		{   
			System.out.println(product.getPrice());
			if(product.getPrice() >= lowP && product.getPrice() <= highP) {
				System.out.println("Inside comparision");
				sortedProducts.add(product);
			}
		}
		if(sortedProducts !=null) {
		mView.addObject("products", sortedProducts);
		}
			
//		sortedProducts=null;
		return mView;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/login")
	public String loginPage() {
		return "userLogin";
	}
	

	@GetMapping("/")
	public ModelAndView userlogin(Model model) {
		ModelAndView mView  = new ModelAndView("index");
		List<Product> products = this.productService.getProducts();
		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;
		
	}
	
	
	
	@GetMapping("/sortLow")
	public ModelAndView sortLow(Model model) {
		ModelAndView mView  = new ModelAndView("index");
		List<Product> products = this.productService.getProducts();
		
		Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
		
		
		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;
		
	}
	
	
	
	@GetMapping("/sortHigh")
	public ModelAndView sortHigh(Model model) {
		ModelAndView mView  = new ModelAndView("index");
		List<Product> products = this.productService.getProducts();
		
		Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
		
		Collections.reverse(products);
		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;
		
	}
	
	
	
	
	@RequestMapping(value = "userloginvalidate", method = RequestMethod.POST)
	public ModelAndView userlogin( @RequestParam("username") String username, @RequestParam("password") String pass,Model model,HttpServletResponse res) {
		
		System.out.println(pass);
		User u = this.userService.checkLogin(username, pass);
		System.out.println(u.getUsername());
		if(u.getRole().equals("ROLE_ADMIN")) {
			System.out.println("Inside Admin");
			ModelAndView mv = new ModelAndView("adminHome");
			adminlogcheck=1;
			mv.addObject("admin", u);
			return mv;
		}
		
		
		if(u.getUsername().equals(username)) {	
			
			res.addCookie(new Cookie("username", u.getUsername()));
			ModelAndView mView  = new ModelAndView("index");	
			mView.addObject("user", u);
			List<Product> products = this.productService.getProducts();

			if (products.isEmpty()) {
				mView.addObject("msg", "No products are available");
			} else {
				mView.addObject("products", products);
			}
			return mView;

		}else {
			ModelAndView mView = new ModelAndView("userLogin");
			mView.addObject("msg", "Please enter correct email and password");
			return mView;
		}
		
	}
	
	
	@GetMapping("/user/products")
	public ModelAndView getproduct() {

		ModelAndView mView = new ModelAndView("uproduct");

		List<Product> products = this.productService.getProducts();

		if(products.isEmpty()) {
			mView.addObject("msg","No products are available");
		}else {
			mView.addObject("products",products);
		}

		return mView;
	}
	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public String newUseRegister(@ModelAttribute User user)
	{
		
		System.out.println(user.getEmail());
		user.setRole("ROLE_NORMAL");
		this.userService.addUser(user);
		
		return "redirect:/";
	}
	
	
	
	   //for Learning purpose of model
		@GetMapping("/test")
		public String Test(Model model)
		{
			System.out.println("test page");
			model.addAttribute("author","jay gajera");
			model.addAttribute("id",40);
			
			List<String> friends = new ArrayList<String>();
			model.addAttribute("f",friends);
			friends.add("xyz");
			friends.add("abc");
			
			return "test";
		}
		
		// for learning purpose of model and view ( how data is pass to view)
		
		@GetMapping("/test2")
		public ModelAndView Test2()
		{
			System.out.println("test page");
			//create modelandview object
			ModelAndView mv=new ModelAndView();
			mv.addObject("name","jay gajera 17");
			mv.addObject("id",40);
			mv.setViewName("test2");
			
			List<Integer> list=new ArrayList<Integer>();
			list.add(10);
			list.add(25);
			mv.addObject("marks",list);
			return mv;
			
			
		}
		
		
		@RequestMapping("/addToCart")
	    public ModelAndView addToCart(HttpServletRequest req) {
			System.out.println("inside it is ");
			String productId=req.getParameter("productId");
			List<Product> simpleList=new ArrayList<>();
			
			System.out.println(productId);
			ModelAndView mView  = new ModelAndView("cartPage");
			int id=Integer.parseInt(productId);
			Product products = this.productService.getProduct(id);
			simpleList.add(products);
			
			mView.addObject("products", simpleList);
			
			return mView;
			
			
	        
	        
	    }
		
		
		
		
		
		
		
		


//	
	  
}