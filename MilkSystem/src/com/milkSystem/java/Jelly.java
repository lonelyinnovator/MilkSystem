package com.milkSystem.java;

import java.util.Date;

public class Jelly extends Product{
	private String flavor;
	public Jelly(String code, String description, float price, Date productionDate, String shelfLife, String flavor) {
		super(code, description, price, productionDate, shelfLife);
		this.flavor = flavor;
	}
	public Jelly() {
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
}
