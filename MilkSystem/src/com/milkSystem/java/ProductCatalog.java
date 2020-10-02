package com.milkSystem.java;

import java.util.ArrayList;
import java.util.Iterator;

public  class ProductCatalog implements Iterable<Product>{
	private ArrayList<Product>products;
	public ProductCatalog() {
		this.products = new ArrayList<Product>();
	}
	public void addProduct(Product product) {
		this.products.add(product);
	}
	public void removeProduct(Product product) {
		this.products.remove(product);
	}
	public Product getProduct(String code) {
		for(Product product:this.products) {
			if(product.getCode() == code) {
				return product;
			}
		}
		return null;
	}
	public int getNumberOfProducts() {
		return this.products.size();
	}
	public Product getProduct(int index) {
		return this.products.get(index);
	}
	public Iterator<Product> iterator() {
		return this.products.iterator();
	}
}
