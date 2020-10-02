package com.milkSystem.java;

import java.util.Date;

public class PureMilk extends Product{
	private String countryOfOrigin;
	private String butterfat;
	private String protein;
	public PureMilk(String code, String description, float price, Date productionDate, String shelfLife,String countryOfOrigin, String butterfat, String protein) {
		super(code, description, price, productionDate, shelfLife);
		this.butterfat = butterfat;
		this.countryOfOrigin = countryOfOrigin;
		this.protein = protein;
	}
	public PureMilk() {
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public String getButterfat() {
		return butterfat;
	}
	public void setButterfat(String butterfat) {
		this.butterfat = butterfat;
	}
	public String getProtein() {
		return protein;
	}
	public void setProtein(String protein) {
		this.protein = protein;
	}
}
