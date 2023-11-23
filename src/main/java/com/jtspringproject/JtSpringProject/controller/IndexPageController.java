package com.jtspringproject.JtSpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.cartService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexPageController {
    @Autowired
    private userService userService;

    @Autowired
    private productService productService;

    @Autowired
    private cartService cartService;

    User u;

    @GetMapping("/")
    public ModelAndView indexPage(Model model) {
        ModelAndView mView = new ModelAndView("index");
        List<Product> products = this.productService.getProducts();
        if (products.isEmpty()) {
            mView.addObject("msg", "No products are available");
        } else {
            mView.addObject("products", products);
        }
        return mView;

    }

    @GetMapping("/login")
    public String loginPage() {
        return "userLogin";
    }

    @GetMapping("/register")
    public String registerUser() {
        return "register";
    }

    @RequestMapping(value = "searchIndex", method = RequestMethod.POST)
    public ModelAndView searchIdex(@RequestParam("search") String search) {
        ModelAndView mView = new ModelAndView("index");
        System.out.println("Search element" + search);

        List<Product> products = this.productService.getProductSearch(search);
        if (products.isEmpty()) {
            mView.addObject("msg", "No products are available");
        } else {
            mView.addObject("products", products);
        }
        return mView;
    }


}
