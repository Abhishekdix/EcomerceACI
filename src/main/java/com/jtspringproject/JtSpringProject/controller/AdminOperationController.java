package com.jtspringproject.JtSpringProject.controller;

import org.springframework.stereotype.Controller;
import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import com.jtspringproject.JtSpringProject.services.categoryService;
import com.jtspringproject.JtSpringProject.services.productService;
import com.jtspringproject.JtSpringProject.services.userService;
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

@Controller
public class AdminOperationController {

    @Autowired
    private userService userService;
    @Autowired
    private categoryService categoryService;

    @Autowired
    private productService productService;

    int adminlogcheck;

    @RequestMapping(value = "admin/loginvalidate", method = RequestMethod.POST)
    public ModelAndView adminlogin( @RequestParam("username") String username, @RequestParam("password") String pass) {

        User user=this.userService.checkLogin(username, pass);

        if(user.getRole().equals("ROLE_ADMIN")) {
            System.out.println("Inside Admin");
            ModelAndView mv = new ModelAndView("adminHome");
            adminlogcheck=1;
            mv.addObject("admin", user);
            return mv;
        }
        else {
            ModelAndView mv = new ModelAndView("adminlogin");
            mv.addObject("msg", "Please enter correct username and password");
            return mv;
        }
    }


    @GetMapping("admin/categories")
    public ModelAndView getcategory() {
        if(adminlogcheck==0){
            ModelAndView mView = new ModelAndView("adminlogin");
            return mView;
        }
        else {
            ModelAndView mView = new ModelAndView("categories");
            List<Category> categories = this.categoryService.getCategories();
            mView.addObject("categories", categories);
            return mView;
        }
    }
    @RequestMapping(value = "admin/categories",method = RequestMethod.POST)
    public String addCategory(@RequestParam("categoryname") String category_name)
    {
        System.out.println(category_name);

        Category category =  this.categoryService.addCategory(category_name);
        if(category.getName().equals(category_name)) {
            return "redirect:categories";
        }else {
            return "redirect:categories";
        }
    }

    @GetMapping("admin/categories/delete")
    public String removeCategoryDb(@RequestParam("id") int id)
    {
        this.categoryService.deleteCategory(id);
        ModelAndView mView = new ModelAndView("categories");
        return "categories";
    }

    @GetMapping("admin/categories/update")
    public String updateCategory(@RequestParam("categoryid") int id, @RequestParam("categoryname") String categoryname)
    {
        Category category = this.categoryService.updateCategory(id, categoryname);
        return "redirect:/admin/categories";
    }




    @GetMapping("admin/products")
    public ModelAndView getproduct() {
        if(adminlogcheck==0){
            ModelAndView mView = new ModelAndView("adminlogin");
            return mView;
        }
        else {
            ModelAndView mView = new ModelAndView("products");

            List<Product> products = this.productService.getProducts();

            if (products.isEmpty()) {
                mView.addObject("msg", "No products are available");
            } else {
                mView.addObject("products", products);
            }
            return mView;
        }

    }
    @GetMapping("admin/products/add")
    public ModelAndView addProduct() {
        ModelAndView mView = new ModelAndView("productsAdd");
        List<Category> categories = this.categoryService.getCategories();
        mView.addObject("categories",categories);
        return mView;
    }

    @RequestMapping(value = "admin/products/add",method=RequestMethod.POST)
    public String addProduct(@ModelAttribute Product product, @RequestParam("categoryid") int categoryId,@RequestParam("productImage") String productImage) {

        Category category = this.categoryService.getCategory(categoryId);

        product.setCategory(category);

        product.setImage(productImage);

        this.productService.addProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("admin/products/update")
    public ModelAndView updateproduct(HttpServletRequest req) {

        String idString=req.getParameter("id");



        int id=Integer.parseInt(idString);

        ModelAndView mView = new ModelAndView("productsUpdate");
        Product product = this.productService.getProduct(id);


        List<Category> categories = this.categoryService.getCategories();
        List<Product> products=new ArrayList<>();




        products.add(product);


        mView.addObject("categories",categories);
        mView.addObject("products", products);
        return mView;
    }

    @RequestMapping(value = "admin/products/updateComit",method=RequestMethod.POST)
    public String updateProduct(@ModelAttribute Product product,@RequestParam("categoryid") int categoryId,@RequestParam("productImage") String productImage)
    {


        Category category = this.categoryService.getCategory(categoryId);

        product.setCategory(category);
        product.setImage(productImage);

        this.productService.updateProduct(product.getId(),product);
        return "redirect:/admin/products";
    }

    @GetMapping("admin/products/delete")
    public String removeProduct(@RequestParam("id") int id)
    {
        this.productService.deleteProduct(id);
        return "redirect:/admin/products";
    }

    @PostMapping("admin/products")
    public String postproduct() {
        return "redirect:/admin/categories";
    }


    @GetMapping(value="admin/adminhome")
    public String adminHome(Model model) {
        if(adminlogcheck==1)
            return "redirect:/admin/adminHome";
        else
            return "redirect:/admin/login";
    }


}
