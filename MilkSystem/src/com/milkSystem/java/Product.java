package com.milkSystem.java;

import java.util.Date;

public class Product {
	private String code;
	private String description;
	private float price;
	private Date productionDate;
	private String shelfLife;
	public Product(String code, String description, float price, Date productionDate, String shelfLife) {
		this.code = code;
		this.description = description;
		this.price = price;
		this.productionDate = productionDate;
		this.shelfLife = shelfLife;
	}
	public Product() {
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getProductionDate() {
		return productionDate;
	}
	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
}
