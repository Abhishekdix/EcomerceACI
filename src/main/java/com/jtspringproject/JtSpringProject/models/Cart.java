package com.jtspringproject.JtSpringProject.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name="cart")
public class Cart {

@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cartid;

@Column
private int productid;

@Column
private int userid;

@Column
private int quantity;

public int getCartid() {
	return cartid;
}

public void setCartid(int cartid) {
	this.cartid = cartid;
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Cart() {
	super();
	// TODO Auto-generated constructor stub
}

public Cart(int cartid, int productid, int userid, int quantity) {
	super();
	this.cartid = cartid;
	this.productid = productid;
	this.userid = userid;
	this.quantity = quantity;
}


}
