package com.jtspringproject.JtSpringProject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jtspringproject.JtSpringProject.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.core.metrics.StartupStep;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.cartService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;
import com.jtspringproject.JtSpringProject.services.categoryService;

@Controller
public class UserController {

	@Autowired
	private userService userService;

	@Autowired
	private productService productService;

	@Autowired
	private cartService cartService;

	@Autowired
	private categoryService categoryService;

	User user;

	Product product;

//	user controller Starts

	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam("search") String search) {
		ModelAndView mView = new ModelAndView("UserHome");
//		System.out.println("Search element" + search);

		List<Product> products = this.productService.getProductSearch(search);
		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;
	}

	@GetMapping("/logout")
	public String logoutPage() {
		return "redirect:/";
	}



	@GetMapping("/UserHome")
	public ModelAndView UserHome(){


		ModelAndView mView = new ModelAndView("UserHome");
		mView.addObject("user", user);
		List<Product> products = this.productService.getProducts();

		List<Cart> cartDetails=this.cartService.getCarts(user);




		mView.addObject("carts",cartDetails);

		if (products.isEmpty()) {
			mView.addObject("msg", "No products are available");
		} else {
			mView.addObject("products", products);
		}
		return mView;

	}





	@RequestMapping(value = "userloginvalidate", method = RequestMethod.POST)
	public ModelAndView userlogin(@RequestParam("username") String username, @RequestParam("password") String pass) {

		String password=this.userService.validate(username);





		if (!(password.equals(pass)) || password.equals("WrongPass")) {

			ModelAndView mView = new ModelAndView("userLogin");

			mView.addObject("msg","UserName or Password is Incorrect");
			return mView;

		}else{






		user = this.userService.checkLogin(username, pass);



			ModelAndView mView = new ModelAndView("UserHome");
			mView.addObject("user", user);
			List<Product> products = this.productService.getProducts();

			List<Category> categories=this.categoryService.getCategories();



			if (products.isEmpty()) {
				mView.addObject("msg", "No products are available");
			} else {
				mView.addObject("categories",categories);
				mView.addObject("products", products);
			}
			return mView;

		}



	}

















	@RequestMapping(value = "newuserregister", method = RequestMethod.POST)
	public ModelAndView newUseRegister(@ModelAttribute User user) {



        List<User> usern=this.userService.getUsers();
		for(User usera:usern){
			if(usera.getUsername().equals(user.getUsername())){
				ModelAndView mView=new ModelAndView("register");

				mView.addObject("msg","Try differnt userName");
				return mView;

			}


		}
		ModelAndView mView=new ModelAndView("userLogin");

		user.setRole("ROLE_NORMAL");
		this.userService.addUser(user);

		return mView;
	}



	@RequestMapping("/cart")
	public ModelAndView cart() {
		ModelAndView mView = new ModelAndView("cartPage");
		List<Cart> cartproductsCarts = new ArrayList<>();
		List<Product> cartList = new ArrayList<>();

		cartproductsCarts = cartService.getCarts(user);

		for (Cart cart : cartproductsCarts) {
			cartList.add(cart.getProduct());
		}
		mView.addObject("products", cartList);

		return mView;

	}

	@RequestMapping("/addToCart")
	public ModelAndView addToCart(HttpServletRequest req) {


		List<Cart> cartproductsCarts = new ArrayList<>();
		List<Product> cartList = new ArrayList<>();

		String productId = req.getParameter("productId");

		cartproductsCarts = cartService.getCarts(user);

		for (Cart cart : cartproductsCarts) {
			cartList.add(cart.getProduct());
		}








		ModelAndView mView = new ModelAndView("cartPage");
		int id = Integer.parseInt(productId);
		Cart cart = new Cart();

		cart.setProduct(this.productService.getProduct(id));
		cart.setUser(user);
		cart.setQuantity(1);




		cartService.addCart(cart);

		Product products = this.productService.getProduct(id);

        products.setQuantity(products.getQuantity()-1);

		this.productService.updateProduct(id,products);
		cartList.add(products);

		mView.addObject("products", cartList);

		return mView;

	}















	@RequestMapping(value = "placeOrder", method = RequestMethod.POST)
	public String placeOrder() {

		cartService.deleteCart(user);

		return "orderplaced";
	}




	@RequestMapping("/deleteCartProduct")
	public ModelAndView deleteCartProduct(HttpServletRequest req)

	{

		String productId = req.getParameter("productId");
		int id = Integer.parseInt(productId);

		Product product= this.productService.getProduct(id);

		product.setQuantity(product.getQuantity()+1);

		this.productService.updateProduct(id,product);


		this.cartService.deleteCartByProduct(product);

		ModelAndView mView = new ModelAndView("cartPage");
		List<Cart> cartproductsCarts = new ArrayList<>();
		List<Product> cartList = new ArrayList<>();

		cartproductsCarts = cartService.getCarts(user);

		for (Cart cart : cartproductsCarts) {
			cartList.add(cart.getProduct());
		}
		mView.addObject("products", cartList);

		return mView;

	}


}