package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.Category;
import com.jtspringproject.JtSpringProject.models.Product;

@Repository
public class productDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
	
	
	
	
	@Transactional
	public List<Product> getProducts(){
		return this.sessionFactory.getCurrentSession().createQuery("from PRODUCT").list();
	}




	@Transactional
	public List<Product> sortLow() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCT p ORDER BY p.price ASC", Product.class).list();
	}

	@Transactional
	public List<Product> sortHigh() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCT p ORDER BY p.price DESC", Product.class).list();
	}



	@Transactional
	public List<Product> sortRange(int lowPrice,int highPrice) {
		return this.sessionFactory.getCurrentSession().createQuery("FROM PRODUCT p WHERE p.price >= :lowPrice AND p.price <= :highPrice ORDER BY p.price ASC", Product.class)
				.setParameter("lowPrice", lowPrice)
				.setParameter("highPrice", highPrice)
				.list();
	}





	@Transactional
	public Product addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		return product;
	}
	
	@Transactional
	public Product getProduct(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Transactional
	public Product updateProduct(Product product){
		this.sessionFactory.getCurrentSession().update(String.valueOf(Product.class),product);
		return product;
	}
	@Transactional
	public boolean deleteProduct(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("DELETE FROM PRODUCT p WHERE p.id = :productId")
				.setParameter("productId", id)
				.executeUpdate() > 0;
	}
    @Transactional
	public List<Product> getProductSearch(String search) {
    	return this.sessionFactory.getCurrentSession()
                .createQuery("FROM PRODUCT p WHERE p.name LIKE :searchTerm", Product.class)
                .setParameter("searchTerm", "%" + search + "%")
                .list();
	}



	}
