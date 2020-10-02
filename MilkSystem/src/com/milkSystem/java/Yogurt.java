package com.milkSystem.java;

import java.util.Date;

public class Yogurt extends Product {
	private String type;
	private String diluteConcentration;
	public Yogurt(String code, String description, float price, Date productionDate, String shelfLife, String type, String diluteConcentration) {
		super(code, description, price, productionDate, shelfLife);
		this.diluteConcentration = diluteConcentration;
		this.type = type;
	}
	public Yogurt() {
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDiluteConcentration() {
		return diluteConcentration;
	}
	public void setDiluteConcentration(String diluteConcentration) {
		this.diluteConcentration = diluteConcentration;
	}
}
