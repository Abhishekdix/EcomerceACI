package com.jtspringproject.JtSpringProject.dao;
import java.util.List;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;
import com.jtspringproject.JtSpringProject.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class cartDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){ this.sessionFactory =sf;}

    @Transactional
    public Cart addCart(Cart cart) {
        this.sessionFactory.getCurrentSession().save(cart);
        return cart;
    }

    @Transactional
    public List<Cart> getCarts(User user) {
        return this.sessionFactory.getCurrentSession().createQuery("FROM cart WHERE user = :user", Cart.class).setParameter("user", user).list();
    }


    @Transactional
    public void updateCart(Cart cart) {
        this.sessionFactory.getCurrentSession().update(cart);
    }

    @Transactional
    public void deleteCart(User user) {
        this.sessionFactory.getCurrentSession().createQuery("DELETE FROM cart WHERE user = :user").setParameter("user", user).executeUpdate();
    }


    @Transactional
    public void deleteCartByProduct(Product product) {
        this.sessionFactory.getCurrentSession().createQuery("DELETE FROM cart WHERE product = :product").setParameter("product", product).executeUpdate();
    }

}
