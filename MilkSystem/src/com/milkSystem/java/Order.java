package com.milkSystem.java;


public class Order{
	private ProductSaleList productSaleList;
	private int total;
	public Order(ProductSaleList productSaleList, int total) {
		this.productSaleList = productSaleList;
		this.total = total;
	}
	public Order() {
	}
	public ProductSaleList getPorProductSaleList() {
		return productSaleList;
	}
	public int getTotal() {
		return total;
	}
}
