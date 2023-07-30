package com.jtspringproject.JtSpringProject.dao;
import java.util.List;

import com.jtspringproject.JtSpringProject.models.Cart;
import com.jtspringproject.JtSpringProject.models.Category;
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
    public List<Cart> getCarts(int userid) {
        return this.sessionFactory.getCurrentSession().createQuery("FROM cart WHERE userid = :userid", Cart.class).setParameter("userid", userid).list();
    }


    @Transactional
    public void updateCart(Cart cart) {
        this.sessionFactory.getCurrentSession().update(cart);
    }

    @Transactional
    public void deleteCart(int userid) {
        this.sessionFactory.getCurrentSession().createQuery("DELETE FROM cart WHERE userid = :userid").setParameter("userid", userid).executeUpdate();
    }

}
