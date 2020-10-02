package com.milkSystem.java;


public class SaleItem {
	private Product product;
	private int quantity;
	public SaleItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	public SaleItem() {
	}
	public int getQuantity() {
		return quantity;
	}
	public Product getProduct() {
		return this.product;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
}
