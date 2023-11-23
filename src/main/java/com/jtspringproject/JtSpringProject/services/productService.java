package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jtspringproject.JtSpringProject.dao.productDao;
import com.jtspringproject.JtSpringProject.models.Product;

@Service
public class productService {
	@Autowired
	private productDao productDao;
	
	public List<Product> getProducts(){
		return this.productDao.getProducts();
	}

	public List<Product> getProductsAsc(){
		return this.productDao.sortLow();
	}

	public List<Product> getProductsDesc(){
		return this.productDao.sortHigh();
	}

	public List<Product> getProductsRange(int lowPrice,int highPrice){
		return this.productDao.sortRange(lowPrice,highPrice);
	}
	
	public Product addProduct(Product product) {
		return this.productDao.addProduct(product);
	}
	
	public List<Product> getProductSearch(String search){
		return this.productDao.getProductSearch(search);
	}
	
	
	
	
	
	public Product getProduct(int id) {
		return this.productDao.getProduct(id);
	}

	public Product updateProduct(int id, @org.jetbrains.annotations.NotNull Product product){
		product.setId(id);
		return this.productDao.updateProduct(product);
	}
	public boolean deleteProduct(int id) {
		return this.productDao.deleteProduct(id);
	}

	
}
