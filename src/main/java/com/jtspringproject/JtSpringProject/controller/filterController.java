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
public class filterController {

    @Autowired
    private userService userService;

    @Autowired
    private productService productService;

    @Autowired
    private cartService cartService;

    User u;

    @RequestMapping(value = "rangeSort", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam("lowPrice") String lowPrice, @RequestParam("highPrice") String highPrice) {
        ModelAndView mView = new ModelAndView("UserHome");

        int highP = Integer.parseUnsignedInt(highPrice);
        int lowP = Integer.parseUnsignedInt(lowPrice);

        System.out.println(lowPrice + " " + highPrice);

        List<Product> products = this.productService.getProductsRange(lowP,highP);

        mView.addObject("products", products);

        return mView;
    }


    @GetMapping("/sortLowToHigh")
    public ModelAndView sortLow(Model model) {
        ModelAndView mView = new ModelAndView("UserHome");
        List<Product> products = this.productService.getProductsAsc();
        if (products.isEmpty()) {
            mView.addObject("msg", "No products are available");
        } else {
            mView.addObject("products", products);
        }
        return mView;

    }

    @GetMapping("/sortHighToLow")
    public ModelAndView sortHigh(Model model) {
        ModelAndView mView = new ModelAndView("UserHome");
        List<Product> products = this.productService.getProductsDesc();
        if (products.isEmpty()) {
            mView.addObject("msg", "No products are available");
        } else {
            mView.addObject("products", products);
        }
        return mView;
    }






}
