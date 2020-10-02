package com.milkSystem.java;

import java.util.Date;


public class MilkDrink extends Product {
	private String flavor;
	private String sugar;
	public MilkDrink(String code, String description, float price, Date productionDate, String shelfLife, String flavor, String sugar) {
		super(code, description, price, productionDate, shelfLife);
		this.flavor = flavor;
		this.sugar = sugar;
	}
	public MilkDrink() {
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
}
