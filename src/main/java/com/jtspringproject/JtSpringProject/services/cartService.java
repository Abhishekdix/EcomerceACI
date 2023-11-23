package com.jtspringproject.JtSpringProject.services;

import com.jtspringproject.JtSpringProject.dao.cartDao;
import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cartService {
    @Autowired
    private cartDao cartDao;

    public Cart addCart(Cart cart)
    {
        return cartDao.addCart(cart);
    }

    public List<Cart> getCarts(User userid){
        return this.cartDao.getCarts(userid);
    }

    public void updateCart(Cart cart){
        cartDao.updateCart(cart);
    }
    public void deleteCart(User userid)
    {
        cartDao.deleteCart(userid);
    }


    public void deleteCartByProduct(Product product)
    {
        cartDao.deleteCartByProduct(product);
    }



}
